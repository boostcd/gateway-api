package com.estafet.boostcd.gateway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estafet.boostcd.gateway.api.dto.EnvironmentDTO;
import com.estafet.boostcd.gateway.api.dto.MicroserviceDTO;
import com.estafet.boostcd.gateway.api.service.MicroserviceService;

@RestController
public class MicroserviceController {

	@Autowired
	private MicroserviceService microserviceService;

	@GetMapping("/microservices")
	public List<EnvironmentDTO> getMicroserviceEnvironments() {
		return microserviceService.getMicroserviceEnvironments();
	}
	
	@GetMapping("/environment/{env}/app/{app}")
	public MicroserviceDTO getMicroservice(@PathVariable String env, @PathVariable String app) {
		return microserviceService.getMicroservice(env, app);
	}

	@PostMapping("/environment/{env}/app/{app}/{action}")
	public ResponseEntity<MicroserviceDTO> doAction(@PathVariable String env, @PathVariable String app,
			@PathVariable String action) {
		return new ResponseEntity<MicroserviceDTO>(microserviceService.doAction(env, app, action),
				HttpStatus.OK);
	}

}