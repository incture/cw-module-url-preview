package com.incture.ptw.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.ptw.dto.PtwTestRecordDto;

@Repository
public class PtwTestRecordDao extends BaseDao {
	@Autowired
	private KeyGeneratorDao keyGeneratorDao;

	public void insertPtwTestRecord(String permitNumber, PtwTestRecordDto ptwTestRecordDto) {
		try {
			Query query = getSession().createNativeQuery(
					"INSERT INTO \"IOP\".\"PTWTESTRECORD\"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			query.setParameter(1, keyGeneratorDao.getPTWTESTREC());
			query.setParameter(2, permitNumber);
			query.setParameter(3, ptwTestRecordDto.getIsCWP());
			query.setParameter(4, ptwTestRecordDto.getIsHWP());
			query.setParameter(5, ptwTestRecordDto.getIsCSE());
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
			query.setParameter(17, ptwTestRecordDto.getIsO2());
			query.setParameter(18, ptwTestRecordDto.getIsLELs());
			query.setParameter(19, ptwTestRecordDto.getIsH2S());
			query.setParameter(20, ptwTestRecordDto.getOther());
			query.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public PtwTestRecordDto getPtwTestRec(String permitNumber) {
		try {
			String sqlString = "select * from IOP.PTWTESTRECORD where PERMITNUMBER=?";
			Query query = getSession().createNativeQuery(sqlString);
			query.setParameter(1, permitNumber);
			PtwTestRecordDto ptwTestRecordDto = new PtwTestRecordDto();
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.getResultList();
			for (Object[] o : list) {
				ptwTestRecordDto.setSerialNo((Integer) o[0]);
				ptwTestRecordDto.setPermitNumber((Integer) o[1]);
				ptwTestRecordDto.setIsCWP(Integer.parseInt(o[2].toString()));
				ptwTestRecordDto.setIsHWP(Integer.parseInt(o[3].toString()));
				ptwTestRecordDto.setIsCSE(Integer.parseInt(o[4].toString()));
				ptwTestRecordDto.setDetectorUsed((String) o[5]);
				ptwTestRecordDto.setDateOfLastCalibration((Date) o[6]);
				ptwTestRecordDto.setTestingFrequency((String) o[7]);
				ptwTestRecordDto.setContinuousGasMonitoring(Integer.parseInt(o[8].toString()));
				ptwTestRecordDto.setPriorToWorkCommencing(Integer.parseInt(o[9].toString()));
				ptwTestRecordDto.setEachWorkPeriod(Integer.parseInt(o[10].toString()));
				ptwTestRecordDto.setEveryHour(Integer.parseInt(o[11].toString()));
				ptwTestRecordDto.setGasTester((String) o[12]);
				ptwTestRecordDto.setGasTesterComments((String) o[13]);
				ptwTestRecordDto.setAreaToBeTested((String) o[14]);
				ptwTestRecordDto.setDeviceSerialNo((String) o[15]);
				ptwTestRecordDto.setIsO2(Integer.parseInt(o[16].toString()));
				ptwTestRecordDto.setIsLELs(Integer.parseInt(o[17].toString()));
				ptwTestRecordDto.setIsH2S(Integer.parseInt(o[18].toString()));
				ptwTestRecordDto.setOther((String) o[19]);
				break;
			}
			return ptwTestRecordDto;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
