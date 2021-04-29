package com.incture.ptw.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.ptw.dao.JsaByPermitNumDao;
import com.incture.ptw.dto.GetJsaByPermitNumPayloadDto;
import com.incture.ptw.util.ResponseDto;

@Service
@Transactional
public class JsaByPermitNumService {
	@Autowired
	private JsaByPermitNumDao getJsaByPermitNumDao;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ResponseDto getJsaByPermitNum(String permitNumber) {
		logger.info("GetJsaByPermitNumServic || getJsaByPermitNum permitNumber " + permitNumber);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);
		try {
			GetJsaByPermitNumPayloadDto getJsaByPermitNumPayloadDto = getJsaByPermitNumDao
					.getJsaByPermitNum(permitNumber);
			if (getJsaByPermitNumPayloadDto != null) {
				responseDto.setData(getJsaByPermitNumPayloadDto);
				responseDto.setMessage("Data displayed successfully");
			} else {
				responseDto.setData(new ArrayList<>());
				responseDto.setMessage("Data not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GetJsaByPermitNumServic || getJsaByPermitNum " + e.getMessage());
			logger.error(e.getStackTrace().toString());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setData(new ArrayList<>());
			responseDto.setMessage(e.getMessage());
		}
		logger.info("GetJsaByPermitNumServic || getJsaByPermitNum " + responseDto);

		return responseDto;
	}
}
