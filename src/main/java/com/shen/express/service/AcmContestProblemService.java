package com.shen.express.service;

import java.util.List;

import com.shen.express.pojo.AcmContestProblem;

public interface AcmContestProblemService {
	public boolean insertContestProblem(AcmContestProblem acmContestProblem);

	public List<AcmContestProblem> showProblems();

	public boolean delete(AcmContestProblem acmContestProblem);

	public AcmContestProblem getPro(String id);

	public boolean modifyPro(AcmContestProblem acmContestProblem);
}
