package com.te.lms.services;

import com.te.lms.dto.BatchDto;

public interface BatchService {

	BatchDto create(BatchDto batchDto);

	BatchDto getBatch(int id);

	void deleteBatch(int id);

	BatchDto updateBatch(int id, BatchDto dto);

}
