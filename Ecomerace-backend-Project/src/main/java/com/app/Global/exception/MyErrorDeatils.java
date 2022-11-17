package com.app.Global.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//lombok annotation used
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyErrorDeatils {
		
	private LocalDateTime timestamp;//localDate ANdTime use
	private String message;// ErrorMeassage 
	private String desc;//Description 
}
