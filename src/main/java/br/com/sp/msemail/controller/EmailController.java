package br.com.sp.msemail.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.msemail.dtos.EmailDTO;
import br.com.sp.msemail.model.Email;
import br.com.sp.msemail.service.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendingEmail")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDto){
		Email email = new Email();
		BeanUtils.copyProperties(emailDto, email);
		emailService.sendEmail(email);
		return new ResponseEntity<Email>(email, HttpStatus.CREATED);
	}
}
