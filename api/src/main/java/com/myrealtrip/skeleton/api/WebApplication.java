package com.myrealtrip.skeleton.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplication
 * @author sarasu
 * @since 2021.09.24
 */
@SpringBootApplication(scanBasePackages = {"com.myrealtrip"})
public class WebApplication {
    public static void main(String [] args) {
        try {
            ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);

            DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
            dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
            dispatcherServlet.setDispatchOptionsRequest(true);
        }catch(Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
