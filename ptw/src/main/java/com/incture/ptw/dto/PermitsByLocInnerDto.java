package com.incture.ptw.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PermitsByLocInnerDto {
	private String createdBy;
	private Date createdDate;
	private List<String> facilityorsite;
	private String jsaPermitNumber;
	private Date lastUpdatedDate;
	private String permitNumber;
	private String ptwPermitNumber;
	private String status;
}
