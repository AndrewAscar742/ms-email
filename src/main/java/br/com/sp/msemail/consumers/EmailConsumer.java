package br.com.sp.msemail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.sp.msemail.dtos.EmailDTO;
import br.com.sp.msemail.model.Email;
import br.com.sp.msemail.service.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void msEmailListener(@Payload() EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		emailService.sendEmail(email);
		System.out.println("Email status: " + email.getStatusEmail());
	}
}
