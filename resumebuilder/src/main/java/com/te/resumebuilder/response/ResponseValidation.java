package com.te.resumebuilder.response;

import java.util.List;

import javax.persistence.Convert;

import com.te.resumebuilder.util.ListToStringConvertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseValidation {

	private boolean error;
	
	@Convert(converter = ListToStringConvertor.class)
	private List<String> message;
	
	private Object data;
}
