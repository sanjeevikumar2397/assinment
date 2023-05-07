package com.te.doctorflow1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponce {
	
	private String message;
	
	private Object data;
	
	private String jwtToken;

}
