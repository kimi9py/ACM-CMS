package com.shen.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.shen.express.dao.AcmContestDao;
import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmUser;

@Component
public class AcmContestDaoImpl implements AcmContestDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	public boolean insertContest(AcmContest acmContest) {
		Integer id = (Integer) hibernateTemplate.save(acmContest);
		if (id != null) {
			return true;
		}

		return false;
	}

	@Override
	public List<AcmContest> getContests() {
		return (List<AcmContest>) hibernateTemplate.find("from AcmContest acmContest order by contest_id desc"); // 降序
	}

	@Override
	public boolean delete(AcmContest acmContest) {
		try {
			hibernateTemplate.delete(acmContest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public AcmContest getContest(String id) {
		try {
			List<AcmContest> list = (List<AcmContest>) hibernateTemplate.find("from AcmContest acmContest where id='" + id + "'");
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modifyContest(AcmContest acmContest) {
		try {
			hibernateTemplate.update(acmContest);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
