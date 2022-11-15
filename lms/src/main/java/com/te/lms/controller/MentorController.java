package com.te.lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.MentorDto;
import com.te.lms.entity.Mentor;
import com.te.lms.response.Response;
import com.te.lms.services.MentorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MentorController {

	private final MentorService service ;
	
	@PostMapping("/createMentor")
	public ResponseEntity<Response> createMentor(@RequestBody MentorDto dto){
		Mentor create = service.create(dto);
		return new ResponseEntity<>(new Response(false, "Data Save Sucessfully", create),HttpStatus.OK);
	}
	
	@GetMapping("/findMentor")
	public ResponseEntity<Response> findMentor(@RequestParam int id){
		Mentor findMentor = service.findMentor(id);
		return new ResponseEntity<>(new Response(false, "Data Based On Id",findMentor ),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMentor")
	public ResponseEntity<Response> delete(@RequestParam int id){
		service.delete(id);
		return new ResponseEntity<>(new Response(false, "Data Deleted Sucessfully", null),HttpStatus.OK);
	}
	
	@PutMapping("/updateMentor/{id}")
	public ResponseEntity<Response> update(@PathVariable int id,@RequestBody MentorDto dto){
		Mentor update = service.update(dto,id);
		return new ResponseEntity<>(new Response(false, "Data Updated Sucessfully", update),HttpStatus.OK);
	}
	
}
