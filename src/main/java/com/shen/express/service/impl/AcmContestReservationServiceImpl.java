package com.shen.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.express.dao.AcmContestReservationDao;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.service.AcmContestReservationService;

@Service
public class AcmContestReservationServiceImpl implements AcmContestReservationService {

	@Autowired
	private AcmContestReservationDao acmContestReservationDao;

	public boolean insertContestReservation(AcmContestReservation acmContestReservation) {
		return acmContestReservationDao.insertContestReservation(acmContestReservation);

	}

	@Override
	public boolean delete(AcmContestReservation acmContestReservation) {
		// TODO Auto-generated method stub
		return acmContestReservationDao.delete(acmContestReservation);
	}

	@Override
	public List<AcmContestReservation> getReservations() {
		// TODO Auto-generated method stub
		return acmContestReservationDao.getReservations();
	}

	@Override
	public AcmContestReservation getRe(String id) {
		// TODO Auto-generated method stub
		return acmContestReservationDao.getRe(id);
	}

	@Override
	public boolean modifyRe(AcmContestReservation AcmContestReservation) {
		// TODO Auto-generated method stub
		return acmContestReservationDao.modifyRe(AcmContestReservation);
	}

}
