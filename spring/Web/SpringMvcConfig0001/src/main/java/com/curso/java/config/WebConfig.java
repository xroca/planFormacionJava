/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author jose maria
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:app.properties")
@Profile("produccion")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;
    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object object) throws Exception {
                log.info("Ejecución del interceptor, método preHandle. Handler: " + object.getClass().getName());
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object object, ModelAndView mav) throws Exception {
                log.info("Ejecución del interceptor, método postHandle. Handler: " + object.getClass().getName());
                log.info("Ejecución del interceptor, método postHandle. ModelAndView: " + mav.getViewName());
            }

            @Override
            public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object object, Exception excptn) throws Exception {
                log.info("Ejecución del interceptor, método afterCompletion. Handler: " + object.getClass().getName());
                log.info("Ejecución del interceptor, método afterCompletion. Excepción: " + excptn);
            }
        });
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public ViewResolver obtenerViewResolver() {
        InternalResourceViewResolver i = new InternalResourceViewResolver();
        i.setPrefix(env.getProperty("viewresolver.prefijo"));
        i.setSuffix(env.getProperty("viewresolver.sufijo"));
        return i;
    }
}
