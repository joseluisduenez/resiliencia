package com.app.resiliencia.controllers;


import java.util.ArrayList;

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
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseLogin login(
 			@RequestParam("username") final String username,
			@RequestParam("pwd") final String pwd

			,HttpServletRequest request
	) throws JsonProcessingException {
		logger.info("login: "+request.getQueryString());
		ResponseLogin response = new ResponseLogin();
		User User	=	userDao.userAllowed(username, pwd);
		 if(User!=null) {
			 if(User.getStatus().equals(1))
					response.setAllowed(true);
			 response.setUser(User);
		 }else
			 response.setAllowed(false);
			 
		
	 
	return response;
	}
	@RequestMapping(value = "/blacklist", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String blacklist(@RequestParam("msisdn") final Integer msisdn) {
		RestTemplate restTemplate = new RestTemplate();
 

//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		BlackListModel black = new BlackListModel();
//		black.setMccMnc(mccmnc);
//		black.setMsisdn(new ArrayList(){
//			{add(msisdn);}
//		});
//		HttpEntity<BlackListModel> entity = new HttpEntity<BlackListModel>(black,headers);
//
//		String response = restTemplate.postForObject(apicoreUrl+"/blacklist", entity, String.class);
//		logger.info("RESPONSE: "+response);
//
//		responseUnsubscribe.setCode("100");
//		responseUnsubscribe.setMessage("success");
		return null;
	}
	@RequestMapping(value = "/send_pin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String send_pin(
	/*		@RequestParam("id_attempt") final String id_attempt,
			@RequestParam("id_carrier") final String id_carrier,
			@RequestParam("id_service_type") final String id_service_type,
			@RequestParam("id_promo") final String id_promo,
			@RequestParam("id_channel") final String id_channel,
			@RequestParam("pin") final String pin,
			@RequestParam("msisdn") final String msisdn,
			@RequestParam("id_service") final Integer id_service*/
			@RequestParam("id_promo") final String id_promo,
			@RequestParam("msisdn") final String msisdn,
			@RequestParam("id_service") final Integer id_service
			,HttpServletRequest request

	) throws JsonProcessingException {

		return null;
	}

	@RequestMapping(value ="/check_subscription", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String check_subscription(@RequestParam("msisdn") final String msisdn, @RequestParam("id_service") final Integer id_service
			,HttpServletRequest request
											) {

		return null;

	}


	@RequestMapping(value ="/unsubscribe", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String unsubscribe(@RequestParam("msisdn") final String msisdn,@RequestParam("id_service") final Integer id_service
									  ) {

		return null;
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
