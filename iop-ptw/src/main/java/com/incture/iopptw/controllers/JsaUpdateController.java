package com.incture.iopptw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.iopptw.dtos.CreateRequestDto;
import com.incture.iopptw.services.JsaUpdateService;
import com.incture.iopptw.utils.ResponseDto;

@RestController
@RequestMapping
public class JsaUpdateController {
	@Autowired
	private JsaUpdateService jsaUpdateService;
	
	@PostMapping("/updatejsa")
	public ResponseDto updateJsa(@RequestBody CreateRequestDto createRequestDto) {
		return jsaUpdateService.updateJsaService(createRequestDto);
	}

}
