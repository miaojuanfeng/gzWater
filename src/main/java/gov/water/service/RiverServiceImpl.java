package gov.water.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.water.dao.RiverDao;

@Service
public class RiverServiceImpl implements RiverService{

	@Autowired
	private RiverDao riverDao;
}
