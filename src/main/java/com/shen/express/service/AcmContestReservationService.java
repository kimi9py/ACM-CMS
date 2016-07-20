package com.shen.express.service;

import java.util.List;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestReservation;

public interface AcmContestReservationService {
	public boolean insertContestReservation(AcmContestReservation acmContestReservation);

	public boolean delete(AcmContestReservation acmContestReservation);

	public List<AcmContestReservation> getReservations();

	public AcmContestReservation getRe(String id);

	public boolean modifyRe(AcmContestReservation AcmContestReservation);
}
