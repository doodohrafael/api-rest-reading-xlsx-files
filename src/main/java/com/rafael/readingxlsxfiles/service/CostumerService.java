package com.rafael.readingxlsxfiles.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rafael.readingxlsxfiles.domain.exception.CostumerNotFoundException;
import com.rafael.readingxlsxfiles.domain.exception.FailedToStoreDataException;
import com.rafael.readingxlsxfiles.domain.model.Costumer;
import com.rafael.readingxlsxfiles.domain.repository.CostumerRepository;
import com.rafael.readingxlsxfiles.helper.CostumerHelper;

@Service
public class CostumerService {

	@Autowired
	CostumerRepository costumerRepository;
	
	public List<Costumer> save(MultipartFile file) {
		try {
			CostumerHelper.isXlsx(file);
			List<Costumer> costumers = CostumerHelper.importDataOfFileXlsx(file.getInputStream());
			costumers = costumerRepository.saveAll(costumers);
			return costumers;
		} catch (RuntimeException | IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new FailedToStoreDataException(
					"No \".xlsx\" file was provided, please insert such a file.");
		}
	}

	public List<Costumer> listAll() {
		return costumerRepository.findAll();
	}
	
	public Costumer findCostumer(Long costumerId) {
		return costumerRepository.findById(costumerId)
				.orElseThrow(() -> new CostumerNotFoundException(costumerId));
	}
}