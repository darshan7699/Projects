package com.te.resumebuilder.services;

import static com.te.resumebuilder.constants.ConstantResume.DATA_NOT_FOUND_EXCEPTION;
import static com.te.resumebuilder.constants.ConstantResume.ID_NOT_FOUND;
import static com.te.resumebuilder.constants.ConstantResume.ID_NOT_PRESENT;
import static com.te.resumebuilder.constants.ConstantResume.ID_NOT_PRESENT2;
import static com.te.resumebuilder.constants.ConstantResume.RESUME2;
import static com.te.resumebuilder.constants.ConstantResume.SOMETHING_WENT_WRONG;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.customexception.DataNotFoundException;
import com.te.resumebuilder.customexception.IdNotFoundException;
import com.te.resumebuilder.customexception.IdNotPresentException;
import com.te.resumebuilder.dto.ResumeDto;
import com.te.resumebuilder.entity.Resume;
import com.te.resumebuilder.repository.ResumeRepo;

@Service
public class ResumeImpl implements ResumeService {

	@Autowired
	ResumeRepo resumeRepo;

	@Override
	public Resume save(ResumeDto dto) {
		try {
			Resume resume = Resume.builder().build();
			BeanUtils.copyProperties(dto, resume);
			List<Resume> findAllByEmployeeId = resumeRepo.findAllByEmployeeId(resume.getEmployeeId());
			int size = findAllByEmployeeId.size();
			resume.setResumeId(RESUME2 + resume.getTotalExperience() + "_" + (size + 1));
			resumeRepo.save(resume);
			return resume;
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<Resume> findAll(String employeeId) {
		try {
			List<Resume> list = resumeRepo.findAllByEmployeeId(employeeId);
			if (!list.isEmpty()) {
				return list;
			} else
				throw new IdNotFoundException(ID_NOT_FOUND);
		} catch (IdNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Resume findBy(String resumeId, String employeeId) {
		try {
			Resume orElseThrow = resumeRepo.findByResumeIdAndEmployeeId(resumeId, employeeId)
					.orElseThrow(() -> new IdNotPresentException(ID_NOT_PRESENT));
			return orElseThrow;
		} catch (IdNotPresentException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Resume update(String resumeId, String employeeId,@Valid  ResumeDto dto) {
		try {
			Optional<Resume> optional = resumeRepo.findByResumeIdAndEmployeeId(resumeId, employeeId);
			Resume resume = optional.get();	
			if (!optional.isEmpty()) {
				BeanUtils.copyProperties(dto, resume);
				String resumeId2 = resume.getResumeId();
				resumeId2.split(resumeId2, 0);
				return resume;
			} else
				throw new DataNotFoundException(DATA_NOT_FOUND_EXCEPTION);

		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<String> findobject(String employeeId) {
		try {
			List<Resume> findAllByEmployeeId = resumeRepo.findAllByEmployeeId(employeeId);
			if (!findAllByEmployeeId.isEmpty()) {
				List<String> list = findAllByEmployeeId.stream().map(t -> t.getResumeId()).toList();
				return list;
			} else
				throw new NullPointerException(ID_NOT_PRESENT2);
		} catch (Exception e) {
			throw e;
		}
	}
}
