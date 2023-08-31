/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmgmt.configs;

import com.busmgmt.formatters.BusCompanyFormatter;
import com.busmgmt.formatters.BusTripFormatter;
import com.busmgmt.pojo.Buscompanies;
import com.busmgmt.validator.BusValidator;
import com.busmgmt.validator.WebApplicationValidator;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.busmgmt.controllers",
    "com.busmgmt.repository",
    "com.busmgmt.service",
    "com.busmgmt.validator"
})
@PropertySource("classpath:configs.properties")
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new BusCompanyFormatter());
        registry.addFormatter(new BusTripFormatter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/resource/js/");
    }

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        
//        r.setViewClass(JstlView.class);
//        r.setPrefix("/WEB-INF/jsp/");
//        r.setSuffix(".jsp");
//        
//        return r;
//    }
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", this.env.getProperty("cloudinary.cloud_name"),
                        "api_key", this.env.getProperty("cloudinary.api_id"),
                        "api_secret", this.env.getProperty("cloudinary.api_secret"),
                        "secure", true));
        return cloudinary;
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();

        m.setBasenames("messages");

        return m;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Bean
    public WebApplicationValidator busValidator() {
        Set<Validator> springValadator = new HashSet<>();
        springValadator.add(new BusValidator());
        
        WebApplicationValidator v = new WebApplicationValidator();
        v.setSpringValidator(springValadator);
        
        return v;
    }
    
    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        
        mailSenderImpl.setHost("smtp.gmail.com");
        mailSenderImpl.setPort(587);
        mailSenderImpl.setUsername("Your-gamil-id");
        mailSenderImpl.setPassword("Your-gmail-password");
        
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable","true");
        javaMailProperties.put("mail.smtp.auth","true");
        javaMailProperties.put("mail.transport.protocol","smtp");
        javaMailProperties.put("mail.debug","true");
        
        mailSenderImpl.setJavaMailProperties(javaMailProperties);
        return mailSenderImpl;
        
    }

}