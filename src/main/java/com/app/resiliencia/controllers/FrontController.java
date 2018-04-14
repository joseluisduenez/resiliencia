package com.app.resiliencia.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.resiliencia.util.Constants;
import com.app.resiliencia.util.Messages;
import com.app.resiliencia.dao.*;
@Controller
@RequestMapping("/")
public class FrontController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
   
    @RequestMapping("")
    public String init(Model model) {
        logger.info("Init");

        //model.addAttribute(Messages.ERROR_MESSAGE,message);
        //model.addAttribute(Constants.URL,url);
        return "loadAngularjs";
    }
}
