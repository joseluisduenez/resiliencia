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
	
	private static final Integer ACTIVO = 1;


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
	PropertyDao PropertyDao;
	@Autowired
	ClasificationDao ClasificationDao;
	@Autowired
	SustentabilidadDao SustentabilidadDao;
	@Autowired
	StateDao StateDao;
	@Autowired 
	CityDao CityDao;
	@Autowired
	WhoAreWeDao WhoAreWeDao;
	@Autowired
	IncomeSourceDao IncomeSourceDao;
	@Autowired
	PositionDao PositionDao;
	@Autowired
	ConsejoDao ConsejoDao;
	@RequestMapping(value = "/getGeneralData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GeneralData generalData(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		GeneralData GeneralData = null;
	try {
  	      	 GeneralData = 	GeneralDataDao.getDataByUserId(userId);
  	      	 GeneralData.setPropertyChoosen(PropertyDao.getDataById(GeneralData.getPropertyTypeId()));
  	      	 GeneralData.setClasificationChoosen(ClasificationDao.getDataById(GeneralData.getClasificationId()));
  	      	 GeneralData.setCity(CityDao.getDataById(GeneralData.getCiudadId()));
	}catch(Exception e) {
		e.printStackTrace();
		GeneralData = new GeneralData();
	}
       
		
	return GeneralData;
	}
	@RequestMapping(value = "/getWhoAreWe", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public WhoAreWe getWhoAreWe(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		WhoAreWe GeneralData = null;
	try {
  	      	 GeneralData = 	WhoAreWeDao.getDataByUserId(userId);
  	      	 if(GeneralData==null) {
  	      		 GeneralData = new WhoAreWe();

  	      	 }
  	      
	}catch(Exception e) {
		e.printStackTrace();
		GeneralData = new WhoAreWe();
	}
    
		
	return GeneralData;
	}
	@RequestMapping(value = "/getSustentabilidad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Sustentabilidad> getSustentabilidad(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Sustentabilidad> Sustentabilidad = null;
	try {
		logger.info("userId: "+userId+ " ACTIVO: "+ACTIVO+" SOURCENME: ");
		Sustentabilidad = 	SustentabilidadDao.getDataByStatus(userId,ACTIVO);
	    logger.info("SIZE: "+Sustentabilidad.size());
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return Sustentabilidad;
	}
	@RequestMapping(value = "/getConsejo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Consejo> getConsejo(
 			@RequestParam("userId") final Integer userId,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Consejo> Consejo = null;
	try {
		logger.info("userId: "+userId+ " ACTIVO: "+ACTIVO+" SOURCENME: ");
		Consejo = 	ConsejoDao.getDataByStatus(userId,ACTIVO);
	    //logger.info("SIZE: "+Sustentabilidad.size());
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return Consejo;
	}
	@RequestMapping(value = "/removeSustentabilidad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer removeSustentabilidad(
 			@RequestParam("id") final Integer id,

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Sustentabilidad> Sustentabilidad = null;
	try {
		logger.info("id: "+id);
		SustentabilidadDao.remove(id);

	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return 200;
	}
	@RequestMapping(value = "/getClasification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getClasification(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	ClasificationDao.getRows();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/getCatalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getCatalog(
 			@RequestParam("catalog") final Integer catalog,


			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		if(catalog.equals(1))
			catalogs = 	ClasificationDao.getRows();
		else if(catalog.equals(2))
			catalogs = 	PropertyDao.getProperties();

	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/addCatalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer addCatalog(
 			@RequestParam("catalog") final Integer catalogid,
 			@RequestParam("name") final String name,


			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("catalog: "+catalogid+" name: "+name);
	try {
		Catalog catalog = new Catalog();
		catalog.setName(name);
		catalog.setStatus(1);
		if(catalogid.equals(1)) {
			catalog.setId(ClasificationDao.getId());
			ClasificationDao.addRow(catalog);
		}
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return null;
	}
	@RequestMapping(value = "/removeCatalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer removeCatalog(
 			@RequestParam("catalog") final Integer catalogid,
 			@RequestParam("id") final Integer id,


			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("catalog: "+catalogid+" name: "+id);
	try {
		
		if(catalogid.equals(1)) {
			ClasificationDao.removeRow(id);
		}
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return null;
	}
	@RequestMapping(value = "/getCities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> geCities(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	CityDao.getRows();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/getIncomeSource", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getIncomeSource(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	IncomeSourceDao.getRows();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	 
	@RequestMapping(value = "/getStates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> geStates(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	StateDao.getRows();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/getProperties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getProperties(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	PropertyDao.getProperties();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/getPositions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Catalog> getPositions(
 			

			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		List<Catalog> catalogs  = null;
	try {
		catalogs = 	PositionDao.getRows();
	      
	}catch(Exception e) {
		e.printStackTrace();
	}
       
		
	return catalogs;
	}
	@RequestMapping(value = "/addSustentabilidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addSustentabilidad(
			@RequestBody Sustentabilidad Sustentabilidad,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addSustentabilidad  : "+Sustentabilidad.getSourceName());
 		try {
	     
	    		  Sustentabilidad.setId(SustentabilidadDao.getId());
	    		  SustentabilidadDao.add(Sustentabilidad);
	    	 
 		      
		}catch(Exception e) {
			e.printStackTrace();
		}	 
	return 00;
	}
	@RequestMapping(value = "/addConsejo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addConsejo(
			@RequestBody Consejo consejo,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addCOnsejo  : "+consejo.getPositionName());
 		try {
	     
	    		  consejo.setId(ConsejoDao.getId());
	    		  ConsejoDao.add(consejo);
	    	 
 		      
		}catch(Exception e) {
			e.printStackTrace();
		}	 
	return 200;
	}
	@RequestMapping(value = "/addGeneralData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int getUser(
			@RequestBody GeneralData GeneralData,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addGeneralData  : "+GeneralData.getComentarios());
		GeneralData thereIsInfo	=	null;
		try {

	    	  thereIsInfo   = 	GeneralDataDao.getDataByUserId(GeneralData.getIdUser());
	    	  if(thereIsInfo==null) {
	    		  GeneralData.setId(GeneralDataDao.getId());
	    		  GeneralDataDao.add(GeneralData);
	    	  }else {
	    		  logger.info("Updating information: "+GeneralData.getPropertyTypeId());
	    		  GeneralDataDao.update(GeneralData);
	    	  }
 		     
		}catch(Exception e) {
			e.printStackTrace();
		}	 
	return 00;
	}
	@RequestMapping(value = "/addWhoAreWe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addWhoAreWe(
			@RequestBody WhoAreWe GeneralData,
			HttpSession session
			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("addWhoAreWe  : ");
		WhoAreWe thereIsInfo	=	null;
		try {

	    	  thereIsInfo   = 	WhoAreWeDao.getDataByUserId(GeneralData.getIdUser());
	    	  if(thereIsInfo==null) {
	    		  GeneralData.setId(WhoAreWeDao.getId());
	    		  WhoAreWeDao.add(GeneralData);
	    	  }else {
	    		  logger.info("Updating information: ");
	    		  WhoAreWeDao.update(GeneralData);
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