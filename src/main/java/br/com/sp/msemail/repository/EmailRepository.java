package br.com.sp.msemail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sp.msemail.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
	
}
