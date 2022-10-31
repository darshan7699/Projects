package com.te.resumebuilder.services;

import java.util.List;

import com.te.resumebuilder.dto.ResumeDto;
import com.te.resumebuilder.entity.Resume;

public interface ResumeService {

	Resume save(ResumeDto dto);

	List<Resume> findAll(String employeeId);

	Resume findBy(String resumeId,String employeeId);

	Resume update(String resumeId,String employeeId, ResumeDto dto);

	List<String> findobject(String employeeId);

}
