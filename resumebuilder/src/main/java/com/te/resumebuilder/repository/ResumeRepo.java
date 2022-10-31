package com.te.resumebuilder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.Resume;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Integer> {

	public List<Resume> findAllByEmployeeId(String id);

	public Optional<Resume> findByResumeIdAndEmployeeId(String resumeId,String employeeId);
}
