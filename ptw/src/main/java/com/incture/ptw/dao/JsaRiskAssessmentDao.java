package com.incture.ptw.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.incture.ptw.dto.JsaRiskAssesmentDto;

@Repository
public class JsaRiskAssessmentDao extends BaseDao {

	public void insertJsaRiskAssessment(String permitNumber, JsaRiskAssesmentDto jsaRiskAssesmentDto) {
		try {
			String sql = "INSERT INTO IOP.JSARISKASSESMENT VALUES (?,?,?)";
			Query query = getSession().createNativeQuery(sql);
			logger.info("sql: " + sql);
			query.setParameter(1, permitNumber);
			query.setParameter(2, jsaRiskAssesmentDto.getMustModifyExistingWorkPractice());
			query.setParameter(3, jsaRiskAssesmentDto.getHasContinuedRisk());
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	public void updateJsaRiskAssessment(JsaRiskAssesmentDto jsaRiskAssesmentDto) {
		try {
			String sql = "UPDATE IOP.JSARISKASSESMENT SET MUSTMODIFYEXISTINGWORKPRACTICE=?,HASCONTINUEDRISK=? WHERE PERMITNUMBER=?";
			logger.info("updateJsaRiskAssessment sql" + sql);
			Query query = getSession().createNativeQuery(sql);
			query.setParameter(1, jsaRiskAssesmentDto.getMustModifyExistingWorkPractice());
			query.setParameter(2, jsaRiskAssesmentDto.getHasContinuedRisk());
			query.setParameter(3, jsaRiskAssesmentDto.getPermitNumber());
			query.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public JsaRiskAssesmentDto getJsaRiskAss(String permitNum){
		JsaRiskAssesmentDto jsaRiskAssesmentDto = new JsaRiskAssesmentDto();
		List<Object[]> obj;
		try{
			String sql = "select distinct PERMITNUMBER, MUSTMODIFYEXISTINGWORKPRACTICE,HASCONTINUEDRISK "
					+ " from IOP.JSARISKASSESMENT where PERMITNUMBER = :permitNum";
			logger.info("JSARISKASSESMENT sql " + sql);
			Query q = getSession().createNativeQuery(sql);
			q.setParameter("permitNum", permitNum);
			obj = q.getResultList();
			for (Object[] a : obj) {
				jsaRiskAssesmentDto.setPermitNumber((Integer) a[0]);
				jsaRiskAssesmentDto.setMustModifyExistingWorkPractice(Integer.parseInt(a[1].toString()));
				jsaRiskAssesmentDto.setHasContinuedRisk(Integer.parseInt(a[2].toString()));
			}
			return jsaRiskAssesmentDto;
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
