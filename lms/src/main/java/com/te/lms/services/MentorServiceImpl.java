package com.te.lms.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.lms.customexception.IdNotFoundException;
import com.te.lms.dto.MentorDto;
import com.te.lms.entity.Mentor;
import com.te.lms.repository.MentorRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

	private final MentorRepo repo;
	
	//private final BatchRepo batchRepo;

	@Override
	public Mentor create(MentorDto dto) {
		try {
			Mentor mentor = Mentor.builder().build();
			BeanUtils.copyProperties(dto, mentor);
			// mentor.setBatch(null);
			return repo.save(mentor);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Mentor findMentor(int id) {
		try {
			return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(int id) {
		try {
			
			Mentor mentor = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
		     repo.delete(mentor);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Mentor update(MentorDto dto, int id) {
		try {
			Mentor mentor = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			BeanUtils.copyProperties(dto, mentor);
			repo.save(mentor);
			return mentor;
		} catch (Exception e) {
			throw e;
		}

	}

}
