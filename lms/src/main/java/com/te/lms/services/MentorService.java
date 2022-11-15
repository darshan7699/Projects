package com.te.lms.services;

import com.te.lms.dto.MentorDto;
import com.te.lms.entity.Mentor;

public interface MentorService {

	Mentor create(MentorDto dto);

	Mentor findMentor(int id);

	void delete(int id);

	Mentor update(MentorDto dto, int id);

}
