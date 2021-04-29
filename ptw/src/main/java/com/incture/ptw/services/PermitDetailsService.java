package com.incture.ptw.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.ptw.dao.PermitDetailsDao;
import com.incture.ptw.dto.PtwDetailsDto;
import com.incture.ptw.util.ResponseDto;

@Service
@Transactional
public class PermitDetailsService {
	@Autowired
	private PermitDetailsDao permitDetailsDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ResponseDto getPermitDetails(String permitNumber, String permitType) {
		logger.info("PermitDetailsService");

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);
		try {
			PtwDetailsDto ptwDetailsDto = permitDetailsDao.getPermitDetails(permitNumber, permitType);
			if (ptwDetailsDto != null) {
				responseDto.setData(ptwDetailsDto);
				responseDto.setMessage("Data displayed successfully");
			} else {
				responseDto.setData(new ArrayList<>());
				responseDto.setMessage("Data not found!");
			}
		} catch (Exception e) {

			logger.error("PermitDetailsService " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setData(new ArrayList<>());
			responseDto.setMessage(e.getMessage());

		}

		logger.info("DownloadDataService " + responseDto);

		return responseDto;

	}
}
