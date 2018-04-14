package com.binbit.resiliencia.controllers;

import com.binbit.resiliencia.util.Constants;
import com.binbit.resiliencia.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
