package com.app.breadapp.dtos;

import lombok.Data;

@Data 

public class MessageResponse {
	private String[] messages=new String[1];
	public MessageResponse(String message) {
		messages[0]=message;
	}
}
