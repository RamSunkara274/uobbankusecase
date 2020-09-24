package com.demo.bank.serviceimpl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.User;
import com.demo.bank.exception.UserRegistrationException;
import com.demo.bank.model.RegistrationModel;
import com.demo.bank.model.ResponseMessage;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.repository.UserRepository;
import com.demo.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	AccountRepository accountRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public ResponseMessage userRegistration(RegistrationModel registerModel) {

		LOGGER.info("register model mapping to database in UserServiceImpl");

		if (registerModel.getAddress().isEmpty() || registerModel.getAdharNumber().isEmpty()
				|| registerModel.getEmail().isEmpty() || registerModel.getPassword().isEmpty()
				|| registerModel.getUserName().isEmpty()) {
			throw new UserRegistrationException("While registering every field is manditory ! Please enter valid data");
		}

		User userEntity = new User();
		BeanUtils.copyProperties(registerModel, userEntity);
		userRepo.save(userEntity);
		Random random = new Random();
		long generatedAccountNumber = (long) (100000000000000L + random.nextFloat() * 900000000000000L);
		Account accountEntity = new Account();
		accountEntity.setAccountNumber(generatedAccountNumber);
		accountEntity.setAccountType("savings");
		Long userId = userEntity.getUserId();
		accountEntity.setUserId(userId);
		// Here we are deposting the minimum balance for every customer
		accountEntity.setBalance(10000.0);
		 accountRepo.save(accountEntity);
		ResponseMessage response = new ResponseMessage();
		response.setMessage("user account created successfully");
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

}
