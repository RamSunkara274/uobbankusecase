package com.demo.bank.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.model.RegistrationModel;
import com.demo.bank.model.ResponseMessage;
import com.demo.bank.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/users")
	@ApiOperation("user registration form")
	public ResponseMessage registration(@Valid @RequestBody RegistrationModel registration) {
		LOGGER.info("****UserCotroller registration method ****");
		return userService.userRegistration(registration);

	}

}
