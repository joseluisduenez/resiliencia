package com.app.resiliencia.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import com.app.resiliencia.dto.DocumentLoad;
import com.app.resiliencia.model.User;
import com.app.resiliencia.util.Constants;
import com.app.resiliencia.util.Messages;
import com.google.gson.Gson;

@Controller
@RequestMapping("/")
public class FrontController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
   
    @RequestMapping("")
    public String init(Model model,HttpSession session) {
        logger.info("Init");
        Boolean allowed = (Boolean) session.getAttribute("allowed");
        String cookie = session.getId();
        logger.info("JSESSION: "+cookie);
        logger.info("allowed: "+session.getAttribute("allowed"));
        
       if(allowed!=null )
    	   if(allowed)
    		   return "main";
    	   else
    		   return "loadAngularjs";
       return "loadAngularjs";
    }
    @RequestMapping(value="main",method = RequestMethod.GET)
    public String main( HttpSession session, HttpServletRequest req,Model model) {
        logger.info("main");
        Boolean allowed = (Boolean) session.getAttribute("allowed");
        String cookie = session.getId();
        logger.info("JSESSION: "+cookie);
        logger.info("allowed: "+session.getAttribute("allowed"));
        model.addAttribute(Messages.FORM_SENT,false);

       if(allowed!=null )
    	   if(allowed)
    		   return "main";
    	   else
    		   return "loadAngularjs";
       return "loadAngularjs";
    }
    
	@RequestMapping(value = "addDoc", method = RequestMethod.POST)
	public String addDoc(
			@RequestParam("file") MultipartFile file,
			HttpSession session
			,HttpServletRequest request,Model model
	) throws IOException {
		logger.info("Bef decode: "+file.getOriginalFilename());
		//StandardMultipartHttpServletRequest ff	=	(StandardMultipartHttpServletRequest) file;
		//logger.info("addDoc  : "+new String(Base64.getDecoder().decode(file.getOriginalFilename())));
		//DocumentLoad data = new Gson().fromJson(new String(Base64.getDecoder().decode(file.getOriginalFilename())), DocumentLoad.class);

//		if(file.isEmpty())
//			logger.info("File is empty");
//		else {
			logger.info("File is not empty File is: "+file.getName());
	        User user =	(User) session.getAttribute("User");
//	        data.setFileName(data.getFileName().substring(12));
//	    	data.setFileName(data.getFileName().replaceAll("\\s+","_"));
	    	 byte[] bytes = file.getBytes();
	            Path path = Paths.get("/home/support/appImages/testing.jpg" );
	            Files.write(path, bytes);
	   //     logger.info("El nombre real es: "+data.getFileName());
		
	            model.addAttribute(Messages.FORM_SENT,true);

	return "main";
	}
}
