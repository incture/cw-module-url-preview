package com.incture.ptw.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.incture.ptw.dto.JsaHazardsHighNoiseDto;

@Repository
public class JsaHazardsHighNoiseDao extends BaseDao{
	public void insertJsaHazardsHighNoiseDao(String permitNumber, JsaHazardsHighNoiseDto jsaHazardsHighNoiseDto){
		try{
			String sql = "INSERT INTO IOP.JSAHAZARDSHIGHNOISE VALUES (?,?,?,?,?,?,?,?)";
			logger.info(sql);
			Query query = getSession().createNativeQuery(sql);
			query.setParameter(1, permitNumber);
			query.setParameter(2, jsaHazardsHighNoiseDto.getHighNoise());
			query.setParameter(3, jsaHazardsHighNoiseDto.getWearCorrectHearing());
			query.setParameter(4, jsaHazardsHighNoiseDto.getManageExposureTimes());
			query.setParameter(5, jsaHazardsHighNoiseDto.getShutDownEquipment());
			query.setParameter(6, jsaHazardsHighNoiseDto.getUseQuietTools());
			query.setParameter(7, jsaHazardsHighNoiseDto.getSoundBarriers());
			query.setParameter(8, jsaHazardsHighNoiseDto.getProvideSuitablecomms());
			query.executeUpdate();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

}
