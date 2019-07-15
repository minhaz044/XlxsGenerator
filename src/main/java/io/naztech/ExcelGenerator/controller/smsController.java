package io.naztech.ExcelGenerator.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.naztech.ExcelGenerator.model.Sms;
import io.naztech.ExcelGenerator.services.SmsServices;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class smsController {
	@Autowired
	private SmsServices smsService;
	@PostMapping("/insert")
	private Sms receiveSms(@RequestBody Sms sms) {
		
		log.debug("RestController Is called");
		//smsService.processData(sms);
		return null;
	}

}
