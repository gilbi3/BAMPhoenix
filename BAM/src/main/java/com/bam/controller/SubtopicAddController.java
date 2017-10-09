package com.bam.controller;

/**
 * 
 */

import com.bam.bean.Subtopic;
import com.bam.exception.CustomException;
import com.bam.service.SubtopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/rest/api/v1/Subtopic/")
@Api(value="catalog", tags="Batch Subtopics", description = "Operations about subtopics covered by batches")
public class SubtopicAddController {

  @Autowired
  SubtopicService subserv;

  /**
   * 
   * @param jsonObj
   * @author Samuel Louis-Pierre, Avant Mathur
   * 
   *         REST controller to add existing subtopic to specified batch
   * @throws CustomException
   */

  @RequestMapping(value = "addSubtopic", method = RequestMethod.POST, produces = "application/json")
  @ApiOperation(value = "Updates the date of a subtopic")
  public void addSubtopic(@RequestBody String jsonObj) throws CustomException {

    Subtopic st = null;
    try {
      st = new ObjectMapper().readValue(jsonObj, Subtopic.class);
    } catch (IOException e) {
      throw new CustomException(e);
    }

    subserv.updateSubtopic(st);
  }

}