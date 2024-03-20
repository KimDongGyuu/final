package com.ace.company_event.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class Company_eventDAOImple implements Company_eventDAO {

	private SqlSessionTemplate sqlmap;
	
	public Company_eventDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public int company_eventWrite(Company_eventDTO eventDto) {
		int count = sqlmap.insert("company_eventWrite",eventDto);
		return count;
	}
	
	@Override
	public List<Company_eventDTO> company_eventList(Map map) {
		List<Company_eventDTO> eventList = sqlmap.selectList("company_eventList",map); 
		return eventList;
	}
	
	@Override
	public int getEventTotalCnt(int event_idx) {
		int count = sqlmap.selectOne("eventTotalCnt",event_idx);
		return count;
	}
	
	@Override
	public Company_eventDTO company_eventContent(Map map) {
		Company_eventDTO eventDto = sqlmap.selectOne("company_eventContnet",map);
		return eventDto;
	}
}
