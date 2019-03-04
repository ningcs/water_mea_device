package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/a")
public class ApiController {

    Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/**")
    public ResponseResult common(HttpServletRequest request) {

        String api = (String) request.getAttribute("api168");

        Map<String, String> params = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = request.getParameter(key);
            params.put(key, value);
        }

        ResponseResult obj = null;

        return obj;
    }


}
