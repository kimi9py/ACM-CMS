package com.shen.express.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.express.dao.AcmUserDao;
import com.shen.express.pojo.AcmUser;
import com.shen.express.service.AcmUserService;

@Service
public class AcmUserServiceImpl implements AcmUserService {
	@Autowired
	private AcmUserDao acmUserDao;

	// 单独插
	public boolean insertUser(AcmUser user) {
		return acmUserDao.insertUser(user);
	}

	// 批量插入
	public boolean insertUsers(List<AcmUser> users) {
		return acmUserDao.insertUsers(users);
	}

	@Override
	public List<AcmUser> getUsers() {
		return acmUserDao.getUsers();
	}

	@Override
	public boolean delete(AcmUser ccmUser) {
		// TODO Auto-generated method stub
		return acmUserDao.delete(ccmUser);
	}

	@Override
	public AcmUser getUser(String user_id) {
		 
		return acmUserDao.getUser(user_id);
	}

	@Override
	public boolean ModifyUser(AcmUser acmUser) {
		// TODO Auto-generated method stub
		return acmUserDao.ModifyUser(acmUser);
	}

}
