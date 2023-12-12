package com.luce.employee.domain.config.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {
	
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean verifyPassword(String originalPassword, String hashPassword) {
		return BCrypt.checkpw(originalPassword, hashPassword);
	}

}
