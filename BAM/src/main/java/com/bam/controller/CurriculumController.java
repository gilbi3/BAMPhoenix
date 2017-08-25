package com.bam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bam.bean.Curriculum;
import com.bam.bean.CurriculumSubtopic;
import com.bam.bean.SubtopicName;
import com.bam.dto.CurriculumSubtopicDTO;
import com.bam.dto.DaysDTO;
import com.bam.service.CurriculumService;
import com.bam.service.CurriculumSubtopicService;
import com.bam.service.SubtopicService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api/v1/Curriculum/")
public class CurriculumController {

	@Autowired
	CurriculumService curriculumService;
	
	@Autowired
	CurriculumSubtopicService curriculumSubtopicService;
	
	@Autowired
	SubtopicService subtopicService;
	
	@RequestMapping(value = "All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Curriculum> getAllCurriculum(){
		return curriculumService.getAllCurriculum();
	}
	
	@RequestMapping(value = "GetCurriculum", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Curriculum getCurriculumById(HttpServletRequest request){
		int curriculumId = Integer.parseInt(request.getParameter("curriculumId"));
		return curriculumService.getCuricullumById(curriculumId);
	}
	
	@RequestMapping(value = "Schedule", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CurriculumSubtopic> getAllCurriculumSchedules(HttpServletRequest request){
		Curriculum c = new Curriculum();
		c.setCurriculumId(Integer.parseInt(request.getParameter("curriculumId")));
		return curriculumSubtopicService.getCurriculumSubtopicForCurriculum(c);
	}
	
	@RequestMapping(value = "TopicPool", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SubtopicName> getTopicPool(){
		return subtopicService.getAllSubtopics();
	}
	
	@RequestMapping(value = "AddCurriculum", method = RequestMethod.POST)
	public void addSchedule(@RequestBody String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		CurriculumSubtopicDTO c = mapper.readValue(json, CurriculumSubtopicDTO.class);
		
		//save curriculum object first

		Curriculum curriculum = new Curriculum();
		curriculum.setCurriculumCreator(c.getMeta().getCurriculum().getCurriculumCreator());
		curriculum.setCurriculumdateCreated(c.getMeta().getCurriculum().getCurriculumdateCreated());
		curriculum.setCurriculumName(c.getMeta().getCurriculum().getCurriculumName());
		curriculum.setCurriculumNumberOfWeeks(c.getMeta().getCurriculum().getCurriculumNumberOfWeeks());
		curriculum.setCurriculumVersion(c.getMeta().getCurriculum().getCurriculumVersion());

		curriculumService.save(curriculum);
		
		CurriculumSubtopic cs = new CurriculumSubtopic();
		cs.setCurriculumSubtopicCurriculumID(curriculum);
		int numWeeks = c.getWeeks().length;
		for(int i = 0; i < numWeeks; i++){
			DaysDTO[] days = c.getWeeks()[i].getDays();
			for(int j = 0; j < days.length; j++){
				SubtopicName[] subtopic = days[j].getSubtopics();
				for(int k = 0; k < subtopic.length; k++){
					cs.setCurriculumSubtopicNameId(subtopic[k]);
					cs.setCurriculumSubtopicWeek(i + 1);
					cs.setCurriculumSubtopicDay(j + 1);
					curriculumSubtopicService.saveCurriculumSubtopic(cs);
				}
			}
		}
	}
	
	@RequestMapping(value = "MakeMaster", method = RequestMethod.GET)
	public void markCurriculumAsMaster(HttpServletRequest request){
		Curriculum c = curriculumService.getCuricullumById(Integer.parseInt(request.getParameter("curriculumId")));
		c.setIsMaster(1);
		
		//find the curriculum with same name and isMaster = 1; set to 0; save
		List<Curriculum> curriculumList = curriculumService.findAllCurriculumByName(c.getCurriculumName());
		
		try{
			Curriculum prevMaster = null;
			for(int i = 0; i < curriculumList.size(); i++){
				if(curriculumList.get(i).getIsMaster() == 1)
					prevMaster = curriculumList.get(i);
			}
			prevMaster.setIsMaster(0);
			curriculumService.save(prevMaster);
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		
		//save new master curriculum
		curriculumService.save(c);
	}
	
}
