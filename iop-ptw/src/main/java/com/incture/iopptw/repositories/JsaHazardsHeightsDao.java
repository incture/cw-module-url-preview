package com.incture.iopptw.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incture.iopptw.dtos.JsaHazardsHeightsDto;

@Repository
public class JsaHazardsHeightsDao extends BaseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertJsaHazardsHeights(String permitNumber, JsaHazardsHeightsDto jsaHazardsHeightsDto) {
		try {
			String sql = "INSERT INTO \"IOP\".\"JSAHAZARDSHEIGHTS\" VALUES (?,?,?,?,?,?)";
			logger.info(sql);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createNativeQuery(sql);
			query.setParameter(1, permitNumber);
			query.setParameter(2, jsaHazardsHeightsDto.getWorkAtHeights());
			query.setParameter(3, jsaHazardsHeightsDto.getDiscussWorkingPractice());
			query.setParameter(4, jsaHazardsHeightsDto.getVerifyFallRestraint());
			query.setParameter(5, jsaHazardsHeightsDto.getUseFullBodyHarness());
			query.setParameter(6, jsaHazardsHeightsDto.getUseLockTypeSnaphoooks());
			query.executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public JsaHazardsHeightsDto getJsaHazardsHeightsDto(String permitNum) {
		List<Object[]> obj;
		JsaHazardsHeightsDto jsaHazardsHeightsDto = new JsaHazardsHeightsDto();
		try {
			String sql = "select distinct PERMITNUMBER, WORKATHEIGHTS,DISCUSSWORKINGPRACTICE,VERIFYFALLRESTRAINT, "
					+ " USEFULLBODYHARNESS,USELOCKTYPESNAPHOOOKS from IOP.JSAHAZARDSHEIGHTS "
					+ " where PERMITNUMBER = :permitNum";
			Query q = getSession().createNativeQuery(sql);
			q.setParameter("permitNum", permitNum);
			obj = q.getResultList();

			for (Object[] a : obj) {
				jsaHazardsHeightsDto.setPermitNumber((Integer) a[0]);
				jsaHazardsHeightsDto.setWorkAtHeights(Integer.parseInt(a[1].toString()));
				jsaHazardsHeightsDto.setDiscussWorkingPractice(Integer.parseInt(a[2].toString()));
				jsaHazardsHeightsDto.setVerifyFallRestraint(Integer.parseInt(a[3].toString()));
				jsaHazardsHeightsDto.setUseFullBodyHarness(Integer.parseInt(a[4].toString()));
				jsaHazardsHeightsDto.setUseLockTypeSnaphoooks(Integer.parseInt(a[5].toString()));
			}
			return jsaHazardsHeightsDto;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void updateJsaHazardsHeights(JsaHazardsHeightsDto jsaHazardsHeightsDto) {
		try {
			String sql = "UPDATE \"IOP\".\"JSAHAZARDSHEIGHTS\" SET  \"WORKATHEIGHTS\"=?,\"DISCUSSWORKINGPRACTICE\"=?,\"VERIFYFALLRESTRAINT\"=?,"
					+ "\"USEFULLBODYHARNESS\"=?,\"USELOCKTYPESNAPHOOOKS\"=? WHERE \"PERMITNUMBER\"=?";
			logger.info("updateJsaHazardsHeights sql" + sql);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createNativeQuery(sql);
			query.setParameter(1, jsaHazardsHeightsDto.getWorkAtHeights());
			query.setParameter(2, jsaHazardsHeightsDto.getDiscussWorkingPractice());
			query.setParameter(3, jsaHazardsHeightsDto.getVerifyFallRestraint());
			query.setParameter(4, jsaHazardsHeightsDto.getUseFullBodyHarness());
			query.setParameter(5, jsaHazardsHeightsDto.getUseLockTypeSnaphoooks());
			query.setParameter(6, jsaHazardsHeightsDto.getPermitNumber());
			query.executeUpdate();
			tx.commit();
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

}
