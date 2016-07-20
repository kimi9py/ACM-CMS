package com.shen.express.service;

import java.util.List;

import com.shen.express.pojo.AcmContest;

public interface AcmContestService {
	public boolean insertContest(AcmContest acmContest);

	public List<AcmContest> getContests();

	public boolean delete(AcmContest acmContest);

	public AcmContest getContest(String id);

	public boolean modifyContest(AcmContest acmContest);
}
