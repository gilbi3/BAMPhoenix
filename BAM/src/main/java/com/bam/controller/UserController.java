package com.bam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bam.bean.BamUser;
import com.bam.bean.Batch;
import com.bam.service.BatchService;
import com.bam.service.PasswordGenerator;
import com.bam.service.UsersDetailsService;


@RestController
@RequestMapping(value = "/api/v1/Users/")
public class UserController {
	
	private final String userID = "userId";
	private final String batchID = "batchId";
	
	@Autowired
	UsersDetailsService userService;

	@Autowired
	BatchService batchService;

	@RequestMapping(value = "All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BamUser> getAllUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "AllTrainers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BamUser> getAllTrainers() {
		return userService.findByRole(2);
	}

	@RequestMapping(value = "AllAssociates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BamUser> getAllAssociates() {
		return userService.findByRole(1);
	}

	@RequestMapping(value = "InBatch", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BamUser> getUsersInBatch(HttpServletRequest request) {

		//Get the batch id from the request
		int batchId = Integer.parseInt( request.getParameter(batchID) );
		
		//Retrieve and return users in a batch from the database
		return userService.findUsersInBatch(batchId);
	}

	@RequestMapping(value = "Drop", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<BamUser> dropUserFromBatch(HttpServletRequest request) {

		//Get the user id from the request
		int userId = Integer.parseInt( request.getParameter(userID) );
		BamUser user = userService.findUserById( userId );
		int batchId = user.getBatch().getId();

		// Drop user from the batch
		user.setBatch(null);
		user.setRole(0);
		userService.addOrUpdateUser(user);

		// Return users from batch without the user
		return userService.findUsersInBatch(batchId);
	}

	
	@RequestMapping(value="Update", method=RequestMethod.POST, produces="application/json")
	public void updateUser(@RequestBody BamUser currentUser) {
		BamUser user = userService.findUserByEmail(currentUser.getEmail());
		currentUser.setPwd(user.getPwd());
		userService.addOrUpdateUser(currentUser);
	}
	
	@RequestMapping(value="Register", method=RequestMethod.POST, produces="application/json")
	public void addUser(@RequestBody BamUser currentUser) throws Exception {
		if(userService.findUserByEmail(currentUser.getEmail())==null){
			currentUser.setRole(1);
			userService.addOrUpdateUser(currentUser);
		} else {
			throw new IllegalArgumentException("Email exists in database");
		}	
	}

	/**
	 * @author Tom Scheffer
	 * @param jsonObject
	 *            - object being passed in
	 * @param session
	 *            - current session
	 * @throws Exception
	 *             - for when previous password is wrong
	 * @param jsonObject - object being passed in
	 * @throws Exception - for when previous password is wrong
	 * 
	 *             Updates the user's password from the update view. Updates
	 *             password to pwd2 when pwd equals their old pwd
	 */

	@RequestMapping(value="Reset", method=RequestMethod.POST, produces="application/java")
	public void resetPassword(@RequestBody BamUser userNewPass) throws Exception{
		BamUser currentUser = userService.findUserByEmail(userNewPass.getEmail());
		if (currentUser.getPwd().equals(userNewPass.getPwd())) {
			currentUser.setPwd(userNewPass.getPwd2());
			userService.addOrUpdateUser(currentUser);

		}else{
			throw new IllegalArgumentException("Wrong password, password not changed");
		}
	}

	@RequestMapping(value = "Remove", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<BamUser> removeUser(HttpServletRequest request) {

		//Get the user id from the request
		int userId = Integer.parseInt( request.getParameter(userID) );
		BamUser user = userService.findUserById( userId );
		int batchId = user.getBatch().getId();

		// Set the user as inactive
		Batch b = null;
		user.setBatch(b);
		userService.addOrUpdateUser(user);

		// Return users from batch without the user
		return userService.findUsersInBatch(batchId);
	}

	@RequestMapping(value = "Add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<BamUser> addUserToBatch(HttpServletRequest request) {

		//Get the user id from the request
		int userId = Integer.parseInt( request.getParameter(userID) );
		//Get the batch to add the user to from the request
		int batchId = Integer.parseInt( request.getParameter(batchID) );
		
		BamUser user = userService.findUserById( userId );
		
		user.setBatch(batchService.getBatchById(batchId));

		userService.addOrUpdateUser(user);

		return userService.findUsersNotInBatch();
	}

	@RequestMapping(value = "NotInABatch", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BamUser> getUsersNotInBatch(HttpServletRequest request) {
		return userService.findUsersNotInBatch();
	}
	
	@RequestMapping(value = "Recovery", method = RequestMethod.POST, produces = "application/json")
    public void RecoverPassword(@RequestBody String email) {
		System.out.println(email);
		System.out.println(email.toString());
    	String generate = PasswordGenerator.makePassword();
        // Lookup user in database by e-mail
        BamUser user = userService.findUserByEmail(email);
        System.out.println(user);
        if (user != null) {
        	user.setPwd(generate);
        	userService.addOrUpdateUser(user);
        	userService.recoverE(user);
            
        } else {
        	throw new IllegalArgumentException("password not changed");

        }

    }

}
