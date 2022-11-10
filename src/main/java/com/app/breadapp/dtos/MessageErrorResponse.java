package com.app.breadapp.dtos;

import lombok.Data;

@Data 

public class MessageErrorResponse {
	private String[] errors=new String[1];
	public MessageErrorResponse(String error) {
		errors[0]=error;
		
	}
}
