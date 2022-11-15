package com.te.lms.entity;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.te.lms.util.ListToString;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonInclude(value = Include.NON_DEFAULT)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mentorId")
public class Mentor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mentorId;
	
	private String mentorName;
	
	private String employeeId; 
	
	private String mail;
	
	@Convert(converter = ListToString.class)
	private List<String> skills;

	@Exclude
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "mentor")
	private List<Batch> batch;
	
	@PreRemove
	public void remove() {
		this.batch.stream().map(add ->{add.setMentor(null);
		return add;}).collect(Collectors.toList());
	}
}
