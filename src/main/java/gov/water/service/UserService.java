package gov.water.service;

import gov.water.model.User;

public interface UserService {
	User selectByPrimaryKey(String stcd);
}
