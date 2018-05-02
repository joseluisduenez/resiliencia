package com.app.resiliencia.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.app.resiliencia.dto.ResponseLogin;
import com.app.resiliencia.model.*;
import com.app.resiliencia.resilienciaDao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.resiliencia.service.*;
@RestController
@RequestMapping(value={"/user"})
public class UserController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Value("${mccmnc}")
	private Integer mccmnc;
	@Value("${apicore.endpoint}")
	private String apicoreUrl;
	@Autowired
	UserDao userDao;
	@Autowired
	MailMail mail;
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseLogin login(
 			@RequestParam("username") final String username,
			@RequestParam("pwd") final String pwd,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("login: "+request.getQueryString());
		ResponseLogin response = new ResponseLogin();
		User User	=	userDao.userAllowed(username, pwd);
	    String cookie = session.getId();
		
	        logger.info("JSESSION: "+cookie);
		 if(User!=null) {
			 SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM. yyyy");
 			 User.setSince(dt1.format(User.getCreatedAt()));

			 if(User.getStatus().equals(1)) {
				response.setAllowed(true);
			    session.setAttribute("allowed", true);
			    session.setAttribute("User", User);

			 }
			 response.setUser(User);
		 }else {
			 response.setAllowed(false);
			 session.setAttribute("allowed", false);

		 }
			 
		
	 
	return response;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(
 	 
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("get User: "+request.getQueryString());
 		  String cookie = session.getId();
	        logger.info("JSESSION: "+cookie);
	        User user =	(User) session.getAttribute("User");
	 
	return user;
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(
 	 
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("get Users: " );
		 
	 
	return userDao.getUsers();
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logout(
 		
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
 		   logger.info("logout");
 	        String cookie = session.getId();
	        logger.info("JSESSION: "+cookie);
     	    session.setAttribute("allowed", false);
 	return "200";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer register(
 			@RequestParam("username") final String username,
			@RequestParam("mail") final String mailto

			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("register: "+request.getQueryString());
		UUID uuid = UUID.randomUUID();
	
		//mail.sendMail("", mailto, "Activacion de cuenta", "Tu usuario es: y tu contrasena es:");
		Integer id	=	userDao.getLastId();
		logger.info("El id es: "+id);
		User User = new User();
		User.setId(id);
		User.setCreatedAt(new Date());
		User.setEmail(mailto);
		User.setName(username);
		User.setPassword(uuid.toString().substring(0,8));
		User.setRole(1);
		User.setStatus(0);
		userDao.addUser(User);
	return 200;
	}
 
 

 


 

	@RequestMapping(value = "/confirm_pin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String confirm_pin(
			@RequestParam("id_attempt") final String id_attempt,
			@RequestParam("id_carrier") final String id_carrier,
			@RequestParam("id_service_type") final String id_service_type,
			@RequestParam("id_promo") final String id_promo,
			@RequestParam("id_channel") final String id_channel,
			@RequestParam("pin") final String pin,
			@RequestParam("msisdn") final String msisdn,
			@RequestParam("id_service") final Integer id_service
	) {


		return null;
	}

}
