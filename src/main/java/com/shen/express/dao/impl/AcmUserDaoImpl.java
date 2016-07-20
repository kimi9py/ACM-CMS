package com.shen.express.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.record.formula.functions.T;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shen.express.dao.AcmUserDao;
import com.shen.express.pojo.AcmContest;
import com.shen.express.pojo.AcmUser;

@Component
public class AcmUserDaoImpl implements AcmUserDao {
	@Resource(name = "hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	// 单独插
	public boolean insertUser(AcmUser user) {
		String uid = (String) hibernateTemplate.save(user);
		if (!StringUtils.isEmpty(uid)) {
			return true;
		}
		return false;
	}

	// 批量插入
	public boolean insertUsers(final List<AcmUser> users) {

		hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				int rows = 0;
				for (AcmUser t : users) {
					session.save(t);
					rows++;
					if (rows % 50 == 0) {
						// 将本批插入的对象立即写入数据库并释放内存
						session.flush();
						session.clear();
					}
				}
				return new Integer(rows);
			}
		});
		return true;
	}

	@Override
	public List<AcmUser> getUsers() {
		return (List<AcmUser>) hibernateTemplate.find("from AcmUser acmUser order by user_id"); // 降序
	}

	@Override
	public boolean delete(AcmUser ccmUser) {
		try {
			hibernateTemplate.delete(ccmUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public AcmUser getUser(String user_id) {
		try {
			List<AcmUser> list = (List<AcmUser>) hibernateTemplate.find("from AcmUser acmUser where user_id='" + user_id + "'");
			return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean ModifyUser(AcmUser acmUser) {
		try {
			hibernateTemplate.update(acmUser);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
