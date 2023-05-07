package com.te.doctorflow1.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuccessResponce {
	
	private Object data;
	
	private String Message;

}
