package gov.water.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.water.dao.DayEVDao;
import gov.water.model.DayEV;

@Service
public class DayEVServiceImpl implements DayEVService{

	@Autowired
	private DayEVDao dayEVDao;

	public DayEV selectByPrimaryKey(String stcd) {
		// TODO Auto-generated method stub
		return dayEVDao.selectByPrimaryKey(stcd);
	}

	@Override
	public DayEV selectByDate(String stcd, String date) {
		// TODO Auto-generated method stub
		return dayEVDao.selectByDate(stcd, date);
	}

	@Override
	public int insertByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		return dayEVDao.insertByPrimaryKey(dayEV);
	}

	@Override
	public int updateByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		return dayEVDao.updateByPrimaryKey(dayEV);
	}

	@Override
	public List<DayEV> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return dayEVDao.selectFromTo(stcd, from, to, offset, pageSize);
	}

	@Override
	public Long selectCount(String stcd, String from, String to) {
		// TODO Auto-generated method stub
		return dayEVDao.selectCount(stcd, from, to);
	}
}
