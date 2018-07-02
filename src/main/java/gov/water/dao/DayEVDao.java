package gov.water.dao;

import java.util.List;

import gov.water.model.DayEV;

public interface DayEVDao {
	DayEV selectByPrimaryKey(String stcd);
	DayEV selectByDate(String stcd, String date);
	int insertByPrimaryKey(DayEV dayEV);
	int updateByPrimaryKey(DayEV dayEV);
	List<DayEV> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize);
}
