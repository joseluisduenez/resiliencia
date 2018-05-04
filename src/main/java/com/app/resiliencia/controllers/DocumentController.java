package com.app.resiliencia.controllers;
import java.util.Base64;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.app.resiliencia.dto.DocumentLoad;
import com.app.resiliencia.dto.ResponseLogin;
import com.app.resiliencia.model.*;
import com.app.resiliencia.resilienciaDao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
@RequestMapping(value={"/document"})
public class DocumentController{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Value("${mccmnc}")
	private Integer mccmnc;
	@Value("${apicore.endpoint}")
	private String apicoreUrl;
	@Autowired
	UserDao userDao;
	@Autowired
	MailMail mail;
 
	
	@RequestMapping(value = "/addDoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer addDoc(
			@RequestParam("file") MultipartFile file,
			HttpSession session
			,HttpServletRequest request
	) throws IOException {
		logger.info("Bef decode: "+file.getOriginalFilename());
		logger.info("addDoc  : "+new String(Base64.getDecoder().decode(file.getOriginalFilename())));
		DocumentLoad data = new Gson().fromJson(new String(Base64.getDecoder().decode(file.getOriginalFilename())), DocumentLoad.class);

		if(file.isEmpty())
			logger.info("File is empty");
		else {
			logger.info("File is not empty File is: ");
	        User user =	(User) session.getAttribute("User");
	        data.setFileName(data.getFileName().substring(12));
	    	data.setFileName(data.getFileName().replaceAll("\\s+","_"));
	    	 byte[] bytes = file.getBytes();
	            Path path = Paths.get("/home/support/appImages/" + data.getFileName());
	            Files.write(path, bytes);
	        logger.info("El nombre real es: "+data.getFileName());
		}
 		  
	 
	return 200;
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
