package com.te.lms.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.lms.customexception.IdNotFoundException;
import com.te.lms.dto.BatchDto;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Mentor;
import com.te.lms.repository.BatchRepo;
import com.te.lms.repository.MentorRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

	private final BatchRepo repo;

	private final MentorRepo mentorRepo;

	@Override
	public BatchDto create(BatchDto batchDto) {
		try {

			Batch batch = Batch.builder().build();
			BeanUtils.copyProperties(batchDto, batch);
			Mentor mentor = mentorRepo.findById(batchDto.getMentorId()).orElseThrow();
			batch.setMentor(mentor);
			mentor.getBatch().add(batch);
			Batch save = repo.save(batch);
			BatchDto dto = new BatchDto();
			BeanUtils.copyProperties(save, dto);
			dto.setMentorName(mentor.getMentorName());
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public BatchDto getBatch(int id) {
		try {
			Batch batch = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			System.out.println(batch);
			BatchDto batchDto = new BatchDto();
			BeanUtils.copyProperties(batch, batchDto);
			batchDto.setMentorName(batch.getMentor().getMentorName());
			return batchDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteBatch(int id) {
		try {
			Batch batch = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			repo.delete(batch);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public BatchDto updateBatch(int id, BatchDto dto) {
		try {
			Batch batch = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
			BeanUtils.copyProperties(dto, batch);
			Mentor mentor = mentorRepo.findById(dto.getMentorId())
					.orElseThrow(() -> new IdNotFoundException("Id Not Found For Set The Mentor"));
			batch.setMentor(mentor);
			Batch save = repo.save(batch);
			BatchDto batchDto = new BatchDto();
			batchDto.setMentorName(mentor.getMentorName());
			BeanUtils.copyProperties(save, batchDto);
			return batchDto;
		} catch (Exception e) {
			throw e;
		}
	}

}
