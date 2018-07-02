package gov.water.dao;

import gov.water.model.User;

public interface UserDao {
	User selectByPrimaryKey(String stcd);
}
