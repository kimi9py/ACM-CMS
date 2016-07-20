package com.shen.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shen.express.dao.AcmContestReservationDao;
import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.pojo.AcmContestReservation;

@Component
public class AcmContestReservationDaoImpl implements AcmContestReservationDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	public boolean insertContestReservation(AcmContestReservation acmContestReservation) {
		Integer id = (Integer) hibernateTemplate.save(acmContestReservation);
		if (id != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(AcmContestReservation acmContestReservation) {
		try {
			hibernateTemplate.delete(acmContestReservation);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AcmContestReservation> getReservations() {
		return (List<AcmContestReservation>) hibernateTemplate.find("from AcmContestReservation acmContestReservation order by id "); // 降序

	}

	@Override
	public AcmContestReservation getRe(String id) {
		try {
			List<AcmContestReservation> list = (List<AcmContestReservation>) hibernateTemplate.find("from AcmContestReservation acmContestReservation where id='" + id + "'");
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modifyRe(AcmContestReservation acmContestReservation) {
		try {
			hibernateTemplate.update(acmContestReservation);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
