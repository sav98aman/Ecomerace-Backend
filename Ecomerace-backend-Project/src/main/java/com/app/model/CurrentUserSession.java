package com.app.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer user_id;
	@Column(name = "uuid")
	private String uuid;
	@Column(name = "timeStamp")
	private LocalDateTime timestamp;
	@Column(name = "login_status")
	private Boolean islogin;
}
