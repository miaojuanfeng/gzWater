package gov.water.service;

import java.util.List;

import gov.water.model.River;

public interface FlowService {
	Long selectCount(String from, String to);
	List<River> selectFromTo(String from, String to, Integer offset, Integer pageSize);
	Long selectCount(String stcd, String from, String to);
	List<River> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize);
}
