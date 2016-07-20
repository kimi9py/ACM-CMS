package com.shen.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.express.dao.AcmContestProblemDao;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.service.AcmContestProblemService;
@Service
public class AcmContestProblemServiceImpl implements AcmContestProblemService {
	@Autowired
	private AcmContestProblemDao acmContestProblemDao ; 
	public boolean insertContestProblem(AcmContestProblem acmContestProblem){
		return acmContestProblemDao.insertContestProblem(acmContestProblem);
	}
	@Override
	public List<AcmContestProblem> showProblems() {
		// TODO Auto-generated method stub
		return acmContestProblemDao.showProblems();
	}
	@Override
	public boolean delete(AcmContestProblem acmContestProblem) {
		// TODO Auto-generated method stub
		return acmContestProblemDao.delete(acmContestProblem);
	}
	@Override
	public AcmContestProblem getPro(String id) {
		// TODO Auto-generated method stub
		return acmContestProblemDao.getPro(id);
	}
	@Override
	public boolean modifyPro(AcmContestProblem acmContestProblem) {
		// TODO Auto-generated method stub
		return acmContestProblemDao.modifyPro(acmContestProblem);
	}

}
