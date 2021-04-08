package com.incture.ptw.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.incture.ptw.dto.PtwTestRecordDto;

@Repository
public class PtwTestRecordDao extends BaseDao {
	public void insertPtwTestRecord(PtwTestRecordDto ptwTestRecordDto){
		Query query = getSession().createNativeQuery("INSERT INTO \"IOP\".\"PTWTESTRECORD\"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		query.setParameter(1, ptwTestRecordDto.getSerialNo());
		query.setParameter(2, ptwTestRecordDto.getPermitNumber());
		query.setParameter(3, ptwTestRecordDto.getIsCwp());
		query.setParameter(4, ptwTestRecordDto.getIsHwp());
		query.setParameter(5, ptwTestRecordDto.getIsCse());
		query.setParameter(6, ptwTestRecordDto.getDetectorUsed());
		query.setParameter(7, ptwTestRecordDto.getDateOfLastCalibration());
		query.setParameter(8, ptwTestRecordDto.getTestingFrequency());
		query.setParameter(9, ptwTestRecordDto.getContinuousGasMonitoring());
		query.setParameter(10, ptwTestRecordDto.getPriorToWorkCommencing());
		query.setParameter(11, ptwTestRecordDto.getEachWorkPeriod());
		query.setParameter(12, ptwTestRecordDto.getEveryHour());
		query.setParameter(13, ptwTestRecordDto.getGasTester());
		query.setParameter(14, ptwTestRecordDto.getGasTesterComments());
		query.setParameter(15, ptwTestRecordDto.getAreaToBeTested());
		query.setParameter(16, ptwTestRecordDto.getDeviceSerialNo());
		query.setParameter(17, ptwTestRecordDto.getIso2());
		query.setParameter(18, ptwTestRecordDto.getIslels());
		query.setParameter(19, ptwTestRecordDto.getIsh2s());
		query.setParameter(20, ptwTestRecordDto.getOther());
		query.executeUpdate();	
	}

}
