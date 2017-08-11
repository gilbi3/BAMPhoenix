package com.bam.logging;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.bam.beans.Batch;



@Aspect
public class LoggerClass {
	
	//Created Logger for Intercepting Methods and logging that Information
	final static Logger logger = Logger.getLogger(LoggerClass.class);

	
	
	/**
	 * Logging Methods from the Batch service class
	 * addOrUpdateBranch()
	 * getBatchById()
	 * getBatchAll()
	 * getBatchByTrainer()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.BatchService.addOrUpdateBatch(..))")
	public void hijackAddOrUpdateBranch(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.BatchService.getBatchById(..))")
	public void hijackGetBatchById(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
		
	}
	
	@Around("execution(* com.bam.service.BatchService.getBatchAll(..))")
	public void hijackGetBatchAll(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.BatchService.getBatchByTrainer(..))")
	public void hijackGetBatchByTrainer(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging methods from the MailService Class
	 * sendMail()
	 * @author Jonathan Layssard
	 */

	@Around("execution(* com.bam.service.MailService.sendMail(..))")
	public void hijackSendMail(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging methods from the PasswordGenerator Class
	 * makePassword()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.PasswordGenerator.makePassword(..))")
	public void hijackMakePassword(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging methods from the SubtopicService class
	 * addSubtopic()
	 * getSubtopicByBatch()
	 * getSubtopicByBatchId()
	 * updateSubtopic()
	 * getStatus()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.Subtopic.addSubtopic(..))")
	public void hijackAddSubtopic(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.Subtopic.getSubtopicByBatch(..))")
	public void hijackGetSubtopicByBatch(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.Subtopic.getSubtopicByBatchId(..))")
	public void hijackGetSubtopicByBatchId(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.Subtopic.updateSubtopic(..))")
	public void hijackUpdateSubtopic(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.Subtopic.getStatus(..))")
	public void hijackGetStatus(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging Methods from the TopicService 
	 * addTopic()
	 * getTopicByBatch()
	 * getTopicByBatchId()
	 * getTopics()
	 * addOrUpdateTopicName()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.TopicService.addTopic(..))")
	public void hijackAddTopic(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.TopicService.getTopicByBatch(..))")
	public void hijackGetTopicByBatch(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.TopicService.getTopicByBatchId(..))")
	public void hijackGetTopicByBatchId(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.TopicService.getTopics(..))")
	public void hijackGetTopics(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.TopicService.addOrUpdateTopicName(..))")
	public void hijackAddOrUpdateTopicName(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging Methods from the UsersDetailsService class
	 * loadUserByUsername()
	 * buildUserForAuthentication()
	 * buildUserAuthority()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.UsersDetailsService.loadUserByUsername(..))")
	public void hijackLoadUserByUsername(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersDetailsService.buildUserForAuthentication(..))")
	public void hijackBuildUserForAuthentication(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersDetailsService.buildUserAuthority(..))")
	public void hijackBuildUserAuthority(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	/**
	 * Logging Methods from UsersService class
	 * addOrUpdateUser()
	 * findAllUsers()
	 * findByRole()
	 * findUserById()
	 * findUserByEmail()
	 * findUsersInBatch()
	 * findUsersNotInBatch()
	 * @author Jonathan Layssard
	 */
	@Around("execution(* com.bam.service.UsersService.addOrUpdateUser(..))")
	public void hijackAddOrUpdateUser(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersService.findAllUsers(..))")
	public void hijackFindAllUsers(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersService.findByRole(..))")
	public void hijackFindByRole(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersService.findUserById(..))")
	public void hijackFindUserById(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersService.findUserByEmail(..))")
	public void hijackFindUserByEmail(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	@Around("execution(* com.bam.service.UsersService.findUserInBatch(..))")
	public void hijackFindUserInBatch(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	@Around("execution(* com.bam.service.UsersService.findUserNotInBatch(..))")
	public void hijackFindUserNotInBatch(ProceedingJoinPoint jp)throws Throwable{
		logger.info("hijacked method : " + jp.getSignature().getName());
		logger.info("hijacked arguments : " + Arrays.toString(jp.getArgs()));
		logger.info(jp.proceed());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		logger.info("data request made at " + sdf.format(new Date(System.currentTimeMillis())));
	}
	
	
}
