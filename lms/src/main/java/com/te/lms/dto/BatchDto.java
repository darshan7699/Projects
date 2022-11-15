package com.te.lms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT )
public class BatchDto {
	
	private String batchName;

	private int mentorId;
	
	private String mentorName;

	private List<String> technologies;

	private String startDate;

	private String endDate;

	private String status;

}
