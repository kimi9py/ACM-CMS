package com.shen.express.dao;

import java.util.List;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.pojo.AcmUser;

public interface AcmContestReservationDao {
	public boolean insertContestReservation(AcmContestReservation acmContestReservation);

	public boolean delete(AcmContestReservation acmContestReservation);

	public List<AcmContestReservation> getReservations();

	public AcmContestReservation getRe(String id);

	public boolean modifyRe(AcmContestReservation acmContestReservation);
}
