package com.te.resumebuilder.util;

import java.sql.Clob;

import javax.persistence.AttributeConverter;

public class ClobToSpring implements AttributeConverter<Clob, String>{

	@Override
	public String convertToDatabaseColumn(Clob attribute) {

		return null;
	}

	@Override
	public Clob convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
