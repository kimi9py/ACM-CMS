package com.shen.express.dao;

import java.util.List;

import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmUser;

public interface AcmContestDao {
	public boolean insertContest(AcmContest acmContest);

	public List<AcmContest> getContests();

	public boolean delete(AcmContest acmContest);

	public AcmContest getContest(String id);

	public boolean modifyContest(AcmContest acmContest);
}
