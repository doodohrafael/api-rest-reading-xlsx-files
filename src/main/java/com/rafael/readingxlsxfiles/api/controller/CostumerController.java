package com.rafael.readingxlsxfiles.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rafael.readingxlsxfiles.domain.model.Costumer;
import com.rafael.readingxlsxfiles.domain.repository.CostumerRepository;
import com.rafael.readingxlsxfiles.service.CostumerService;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

	@Autowired
	CostumerService costumerService;
	
	@Autowired
	CostumerRepository costumerRepository;
	
	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Costumer> uploadCostumers(@RequestBody @RequestParam("file") MultipartFile file) {
		List<Costumer> costumers = costumerService.save(file);
		return costumers;
	}

	@GetMapping
	public List<Costumer> listAll() {
		return costumerRepository.findAll();
	}

	@GetMapping("/{costumerId}")
	public Costumer findById(@PathVariable Long costumerId) {
		return costumerService.findCostumer(costumerId);
	}
}