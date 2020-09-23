package com.demo.bank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.bank.model.RegistrationModel;
import com.demo.bank.model.ResponseMessage;

@Service
public interface UserService {

	public ResponseMessage userRegistration(RegistrationModel registerModel);

}
