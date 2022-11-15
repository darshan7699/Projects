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

import com.te.lms.dto.BatchDto;
import com.te.lms.response.Response;
import com.te.lms.services.BatchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BatchController {

	private final BatchService batchService;

	@PostMapping("/createBatch")
	public ResponseEntity<Response> createBatch(@RequestBody BatchDto batchDto) {
		BatchDto create = batchService.create(batchDto);
		return new ResponseEntity<>(new Response(false, "Batch Created Sucessfully", create), HttpStatus.OK);
	}

	@GetMapping("/getBatch")
	public ResponseEntity<Response> getBatch(@RequestParam int id) {
		return new ResponseEntity<>(new Response(false, "Batch Details Based On Id", batchService.getBatch(id)),
				HttpStatus.OK);
	}

	@DeleteMapping("/deleteBatch")
	public ResponseEntity<Response> deleteBatch(@RequestParam int id) {
		batchService.deleteBatch(id);
		return new ResponseEntity<>(new Response(false, "Batch Deleted Sucessfully", null), HttpStatus.OK);
	}

	@PutMapping("/updateBatch/{id}")
	public ResponseEntity<Response> updateBatch(@PathVariable int id, @RequestBody BatchDto dto) {
		BatchDto updateBatch = batchService.updateBatch(id, dto);
		return new ResponseEntity<>(new Response(false, "Batch Updated Sucessfully", updateBatch), HttpStatus.OK);
	}

}
