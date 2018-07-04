package gov.water.service;

import java.util.List;

import gov.water.model.User;

public interface UserService {
	User selectByPrimaryKey(String stcd);
	List<User> selectAll();
}
