package gov.water.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.water.dao.FlowDao;
import gov.water.model.River;

@Service
public class FlowServiceImpl implements FlowService{

	@Autowired
	private FlowDao flowDao;

	public Long selectCount(String from, String to) {
		// TODO Auto-generated method stub
		return flowDao.selectCount(from, to);
	}

	public List<River> selectFromTo(String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return flowDao.selectFromTo(from, to, offset, pageSize);
	}

	public Long selectCount(String stcd, String from, String to) {
		// TODO Auto-generated method stub
		return flowDao.selectCount(stcd, from, to);
	}

	public List<River> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return flowDao.selectFromTo(stcd, from, to, offset, pageSize);
	}
}
