package gov.water.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.water.dao.UserDao;
import gov.water.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User selectByPrimaryKey(String stcd) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(stcd);
	}

}
