package com.shen.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shen.express.dao.AcmContestProblemDao;
import com.shen.express.pojo.AcmContestProblem;
import com.shen.express.pojo.AcmContestReservation;
import com.shen.express.pojo.AcmUser;

@Component
public class AcmContestProblemDaoImpl implements AcmContestProblemDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	public boolean insertContestProblem(AcmContestProblem acmContestProblem) {
		Integer id = (Integer) hibernateTemplate.save(acmContestProblem);
		if (id != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<AcmContestProblem> showProblems() {
		return (List<AcmContestProblem>) hibernateTemplate.find("from AcmContestProblem acmContestProblem order by contest_id "); // 降序
	}

	@Override
	public boolean delete(AcmContestProblem acmContestProblem) {
		try {
			hibernateTemplate.delete(acmContestProblem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public AcmContestProblem getPro(String id) {
		try {
			List<AcmContestProblem> list = (List<AcmContestProblem>) hibernateTemplate.find("from AcmContestProblem acmContestProblem where id='" + id + "'");
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modifyPro(AcmContestProblem acmContestProblem) {
		try {
			hibernateTemplate.update(acmContestProblem);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
