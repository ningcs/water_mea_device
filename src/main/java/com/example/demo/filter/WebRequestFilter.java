package com.example.demo.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebRequestFilter extends OncePerRequestFilter {

    Log logger = LogFactory.getLog(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String uri = httpServletRequest.getRequestURI();
        logger.info("uri:" + uri);

        if (!uri.startsWith("/p/") && !uri.startsWith("/a/")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {

            WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getServletContext());
//            WhiteListService whiteListService = wac.getBean(WhiteListService.class);
//
//            List<WhiteList> whiteListList = whiteListService.findAllIsWhite();
//            List<String> whites = new ArrayList<>();
//            if (whiteListList != null && whiteListList.size() > 0) {
//                for (WhiteList whiteList : whiteListList) {
//                    whites.add(whiteList.getUri());
//                }
//            }

//            //dev
//            //whites.add(uri);
//
//            logger.info("whites:" + whites);
//
//            //--------------
//            HttpSession session = httpServletRequest.getSession();
//
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                user = new User();
//            }

            if (uri != null && !"".equals(uri.trim()) && uri.startsWith("/p/")) {

                String page = uri.replaceFirst("/p/", "");
                logger.info("add request attribute {page:" + page + "}");
                httpServletRequest.setAttribute("page168", page);

            }
//            if (uri != null && !"".equals(uri.trim()) && uri.startsWith("/a/")) {
//
//                String api = uri.replaceFirst("/a/", "");
//                logger.info("add request attribute {api:" + api + "}");
//                httpServletRequest.setAttribute("api168", api);
//
//            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        }
    }
}
