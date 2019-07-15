package io.naztech.ExcelGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.naztech.ExcelGenerator.services.SmsServices;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */

@Slf4j
public class App 
{
    public static void main( String[] args )
    {
    	log.debug("Spring Boot is Started");
      // SpringApplication.run(App.class, args);
    	SmsServices smsservice=new SmsServices();
    	smsservice.generateExcell();
    	System.out.println("*****************************");
    }
}
