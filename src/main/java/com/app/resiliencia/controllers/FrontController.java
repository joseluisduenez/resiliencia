package com.app.resiliencia.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.resiliencia.util.Constants;
import com.app.resiliencia.util.Messages;

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
    public String main( HttpSession session, HttpServletRequest req) {
        logger.info("main");
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
}
