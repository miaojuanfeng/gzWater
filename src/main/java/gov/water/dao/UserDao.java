package gov.water.dao;

import java.util.List;

import gov.water.model.User;

public interface UserDao {
	User selectByPrimaryKey(String stcd);
	List<User> selectAll();
}
