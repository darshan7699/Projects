package com.te.resumebuilder.controller;

import static com.te.resumebuilder.constants.ConstantResume.ALL_RESUMES_OF_THIS_ID;
import static com.te.resumebuilder.constants.ConstantResume.LIST_OF_RESUMES;
import static com.te.resumebuilder.constants.ConstantResume.UPDATED_RESUME;
import static com.te.resumebuilder.constants.ConstantResume.YOUR_RESUME_BUILD_SUCCESSFULLY;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.dto.ResumeDto;
import com.te.resumebuilder.entity.Resume;
import com.te.resumebuilder.response.Response;
import com.te.resumebuilder.services.ResumeService;

@RestController
public class ResumeController {

	@Autowired
	ResumeService resumeService;

	@PostMapping("/saveData")
	public ResponseEntity<Response> save(@RequestBody @Valid ResumeDto dto) {
		Resume save = resumeService.save(dto);
		return new ResponseEntity<>(new Response(false, YOUR_RESUME_BUILD_SUCCESSFULLY, save), HttpStatus.OK);
	}

	@PostMapping("/findAll")
	public ResponseEntity<Response> findAll(@RequestParam String employeeId) {
		List<Resume> findAll = resumeService.findAll(employeeId);
		return new ResponseEntity<>(new Response(false, ALL_RESUMES_OF_THIS_ID, findAll), HttpStatus.OK);
	}

	@PostMapping("/findByResumeId")
	public ResponseEntity<Response> findBy(@RequestParam String resumeId, String employeeId) {
		Resume findBy = resumeService.findBy(resumeId, employeeId);
		return new ResponseEntity<>(new Response(false, ALL_RESUMES_OF_THIS_ID, findBy), HttpStatus.OK);
	}

	@PutMapping("/update/{resumeId},{employeeId}")
	public ResponseEntity<Response> update(@PathVariable("resumeId") String resumeId,
			@PathVariable("employeeId") String employeeId, @Valid @RequestBody ResumeDto dto) {
		Resume update = resumeService.update(resumeId, employeeId, dto);
		return new ResponseEntity<>(new Response(false, UPDATED_RESUME, update), HttpStatus.OK);
	}

	@PostMapping("/objectList/{employeeId}")
	public ResponseEntity<Response> findobject(@PathVariable("employeeId") String employeeId) {
		List<String> findobject = resumeService.findobject(employeeId);
		return new ResponseEntity<>(new Response(false, LIST_OF_RESUMES, findobject), HttpStatus.OK);

	}
}
