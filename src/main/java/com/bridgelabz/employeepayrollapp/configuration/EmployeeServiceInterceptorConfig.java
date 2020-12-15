package com.bridgelabz.employeepayrollapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bridgelabz.employeepayrollapp.interceptor.EmployeeServiceInterceptor;

@Component
public class EmployeeServiceInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    EmployeeServiceInterceptor employeeServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(employeeServiceInterceptor);
    }

}
