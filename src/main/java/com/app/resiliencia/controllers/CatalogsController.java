package com.app.resiliencia.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.app.resiliencia.dto.ResponseLogin;
import com.app.resiliencia.model.*;
import com.app.resiliencia.resilienciaDao.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.resiliencia.service.*;
@RestController
@RequestMapping(value={"/catalogs"})
public class CatalogsController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Value("${mccmnc}")
	private Integer mccmnc;
	@Value("${apicore.endpoint}")
	private String apicoreUrl;
	@Autowired
	UserDao userDao;
	@Autowired
	MailMail mail;
	
	@Autowired 
	GeneralDataDao GeneralDataDao;
	
	@Autowired
	SustentabilidadDao SustentabilidadDao;
	@RequestMapping(value = "/getGeneralData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralData generalData(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		GeneralData GeneralData = null;
	try {
  	      	 GeneralData = 	GeneralDataDao.getDataByUserId(userId);
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return GeneralData;
	}
	@RequestMapping(value = "/getSustentabilidad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sustentabilidad getSustentabilidad(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		Sustentabilidad Sustentabilidad = null;
	try {
		Sustentabilidad = 	SustentabilidadDao.getDataByUserId(userId);
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return Sustentabilidad;
	}
	@RequestMapping(value = "/addSustentabilidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addSustentabilidad(
			@RequestBody Sustentabilidad Sustentabilidad,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addSustentabilidad  : "+Sustentabilidad.getId());
		Sustentabilidad thereIsInfo	=	null;
		try {
			  User user =	(User) session.getAttribute("User");
	    	  thereIsInfo   = 	SustentabilidadDao.getDataByUserId(Sustentabilidad.getIdUser());
	    	  if(thereIsInfo==null) {
	    		  SustentabilidadDao.add(Sustentabilidad);
	    	  }else {
	    		  SustentabilidadDao.update(Sustentabilidad);
	    	  }
 		      
		}catch(Exception e) {
			e.printStackTrace();
		}	 
	return 00;
	}
	@RequestMapping(value = "/addGeneralData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int getUser(
			@RequestBody GeneralData GeneralData,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addGeneralData  : "+GeneralData.getId());
		GeneralData thereIsInfo	=	null;
		try {
			  User user =	(User) session.getAttribute("User");
	    	  thereIsInfo   = 	GeneralDataDao.getDataByUserId(GeneralData.getIdUser());
	    	  if(thereIsInfo==null) {
	    		  GeneralDataDao.add(GeneralData);
	    	  }else {
	    		  GeneralDataDao.update(GeneralData);
	    	  }
 		      
		}catch(Exception e) {
			e.printStackTrace();
		}	 
	return 00;
	}
	
	@RequestMapping(value = "/activateUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer activateUser(
			@RequestParam("id") final Integer id,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("activateUser " );
		User user = userDao.getUserById(id);
		if(user.getStatus().equals(1)) {
			user.setStatus(0);
		}else {
			logger.info("Mail to: "+user.getEmail());
			mail.sendMail("resilienciaapp@gmail.com", user.getEmail(), "Activacion de cuenta", "Tu usuario es: "+user.getEmail()+" y tu contrasena es: "+user.getPassword());
			user.setStatus(1);
		}
		userDao.updateUser(user);
	return 200;
	}
	 
	
	@RequestMapping(value = "/recover", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer recover(
			@RequestParam("mail") final String mailto,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("activateUser " );
		User user = userDao.getUserByEmail(mailto);
		logger.info("Mail to: "+user.getEmail());
		mail.sendMail("resilienciaapp@gmail.com", user.getEmail(), "Informacion para acceder a portal. ", "Tu usuario es: "+user.getEmail()+" y tu contrasena es: "+user.getPassword());
 	 
 	return 200;
	}
	
	@RequestMapping(value = "/changeRole", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer changeRole(
			@RequestParam("id") final Integer id,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("changeRole " );
		User user = userDao.getUserById(id);
		if(user.getRole().equals(1)) {
			user.setRole(0);
		}else {
			user.setRole(1);
		}
		userDao.updateUser(user);
	return 200;
	}
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(
 	 
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("get Users: " );
		 
	 
	return userDao.getUsers();
	}
	@RequestMapping(value = "/validateByEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer validateByEmail(
			@RequestParam("email") final String email,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("get Users: " );
		if(userDao.getUserByEmail(email)==null)
				{
			return 0;
				}
		else
			return 1;
	
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
			@RequestParam("mail") final String mailto,
			@RequestParam("tel") final Integer tel,
			@RequestParam("pwd") final String pwd,
			@RequestParam("comment") final String comment


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
		User.setPassword(pwd);
		User.setTelefono(tel);
		User.setRole(1);
		User.setComments(comment);
		User.setStatus(0);
		userDao.addUser(User);
	return 200;
	}
 
 

 



}
