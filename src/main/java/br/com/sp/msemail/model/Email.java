package br.com.sp.msemail.model;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.sp.msemail.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID emailId;
	/*
	 * OwnerRef: Referência do proprietário, esse campo é pra guardar o ID do usuário que estamos enviando
	 */
	private String ownerRef;
	/*
	 * emailFrom: é o email de quem está enviando
	 */
	private String emailFrom;
	/*
	 * emailTo: é o email de quem está recebendo
	 */
	private String emailTo;
	/*
	 * title: titulo do e-mail
	 */
	private String title;
	/*
	 *text: o corpo do e-mail 
	 */
	@Column(columnDefinition = "TEXT")
	private String text;
	private LocalDateTime sendDateTime;
	private StatusEmail statusEmail;
	
	public Email() {
		// TODO Auto-generated constructor stub
	}
	
	public Email(String ownerRef, String emailFrom, String emailTo, String title, String text,
			LocalDateTime sendDateTime, StatusEmail statusEmail) {
		super();
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.title = title;
		this.text = text;
		this.sendDateTime = sendDateTime;
		this.statusEmail = statusEmail;
	}

	public UUID getEmailId() {
		return emailId;
	}

	public void setEmailId(UUID emailId) {
		this.emailId = emailId;
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getSendDateTime() {
		return sendDateTime;
	}

	public void setSendDateTime(LocalDateTime sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}
}
