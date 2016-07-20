package com.shen.express.service;

import java.util.List;

import com.shen.express.pojo.AcmUser;

public interface AcmUserService {
	// 单独插
	public boolean insertUser(AcmUser user);

	// 批量插入
	public boolean insertUsers(List<AcmUser> users);

	public List<AcmUser> getUsers();

	public boolean delete(AcmUser ccmUser);

	public AcmUser getUser(String user_id);

	public boolean ModifyUser(AcmUser acmUser);
}
