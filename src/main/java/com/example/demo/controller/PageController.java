package com.example.demo.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/p")
public class PageController {

    Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/**")
    public ModelAndView common(ModelAndView mav, HttpServletRequest request) {

        String page = (String) request.getAttribute("page168");

        logger.info("page file local real address:templates.pages/" + page);

        mav.setViewName("pages/" + page);
        mav.addObject("staticPath", "");
        mav.addObject("version", "0.0.1");
        mav.addObject("user", request.getSession().getAttribute("user"));
        return mav;
    }


}
