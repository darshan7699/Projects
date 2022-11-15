package com.te.lms.dto;

import java.util.List;

import lombok.Data;
@Data

public class MentorDto {
	
	private String mentorName;

	private String employeeId;

	private String mail;

	private List<String> skills;

}
