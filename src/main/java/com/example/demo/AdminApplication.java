package com.example.demo;

import com.example.demo.filter.WebRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(webRequestFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}


	public WebRequestFilter webRequestFilter() {
		return new WebRequestFilter();
	}
}
