package com.shen.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.express.dao.AcmContestDao;
import com.shen.express.pojo.AcmContest;
import com.shen.express.service.AcmContestService;

@Service
public class AcmContestServiceImpl implements AcmContestService {
	@Autowired
	private AcmContestDao acmContestDao;

	public boolean insertContest(AcmContest acmContest) {
		return acmContestDao.insertContest(acmContest);
	}

	@Override
	public List<AcmContest> getContests() {

		return acmContestDao.getContests();
	}

	@Override
	public boolean delete(AcmContest acmContest) {
		// TODO Auto-generated method stub
		return acmContestDao.delete(acmContest);
	}

	@Override
	public AcmContest getContest(String id) {
		// TODO Auto-generated method stub
		return acmContestDao.getContest(id);
	}

	@Override
	public boolean modifyContest(AcmContest acmContest) {
		// TODO Auto-generated method stub
		return acmContestDao.modifyContest(acmContest);
	}

}
