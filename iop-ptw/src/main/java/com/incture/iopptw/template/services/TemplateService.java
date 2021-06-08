package com.incture.iopptw.template.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.iopptw.repositories.KeyGeneratorDao;
import com.incture.iopptw.template.dtos.TemplateDto;
import com.incture.iopptw.template.repositories.TemplateDao;
import com.incture.iopptw.utils.ResponseDto;

@Service
@Transactional
public class TemplateService {
	@Autowired
	private TemplateDao templateDao;
	@Autowired
	private KeyGeneratorDao keyGeneratorDao;

	public ResponseDto createTemplateService(TemplateDto templateDto) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(true);
		responseDto.setStatusCode(200);
		try {
			templateDto.setId(Integer.parseInt(keyGeneratorDao.getTEMPLATE()));
			templateDao.createTemplate(templateDto);
			responseDto.setMessage("Template Created Successfully");
		} catch (Exception e) {
			responseDto.setStatus(false);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}

	public ResponseDto getAllTemplateList() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(true);
		responseDto.setStatusCode(200);
		try{
			responseDto.setData(templateDao.getAllTemplateList());
			responseDto.setMessage("Success");
		}catch (Exception e) {
			responseDto.setStatus(false);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}

}
