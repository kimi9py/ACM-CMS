package com.shen.express.dao;

import java.util.List;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.pojo.AcmContestReservation;

public interface AcmContestProblemDao {
	public boolean insertContestProblem(AcmContestProblem acmContestProblem);

	public List<AcmContestProblem> showProblems();

	public boolean delete(AcmContestProblem acmContestProblem);
	
	public AcmContestProblem getPro(String id);

	public boolean modifyPro(AcmContestProblem acmContestProblem);
}
