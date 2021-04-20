package com.incture.ptw.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.incture.ptw.dto.PtwPeopleDto;

@Repository
public class PtwPeopleDao extends BaseDao {
	public void insertPtwPeople(PtwPeopleDto ptwPeopleDto) {
		Query query = getSession().createNativeQuery("INSERT INTO \"IOP\".\"PTWPEOPLE\" VALUES (?,?,?,?,?,?,?,?,?)");
		query.setParameter(1, ptwPeopleDto.getSerialNo());
		query.setParameter(2, ptwPeopleDto.getPermitNumber());
		query.setParameter(3, ptwPeopleDto.getFirstName());
		query.setParameter(4, ptwPeopleDto.getLastName());
		query.setParameter(5, ptwPeopleDto.getContactNumber());
		query.setParameter(6, ptwPeopleDto.getHasSignedJsa());
		query.setParameter(7, ptwPeopleDto.getHasSignedCwp());
		query.setParameter(8, ptwPeopleDto.getHasSignedHwp());
		query.setParameter(9, ptwPeopleDto.getHasSignedCse());

		query.executeUpdate();
	}

}
