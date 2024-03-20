package com.ace.company_event.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ace.company_event.model.Company_eventDAO;
import com.ace.company_event.model.Company_eventDTO;

public class company_eventServiceImple implements company_eventService {

	private Company_eventDAO Company_eventDao;

	public Company_eventDAO getCompany_eventDao() {
		return Company_eventDao;
	}

	public void setCompany_eventDao(Company_eventDAO company_eventDao) {
		Company_eventDao = company_eventDao;
	}
	
	@Override
	public int company_eventWrite(Company_eventDTO eventDto) {
		int count = Company_eventDao.company_eventWrite(eventDto);
		return count;
	}
	
	@Override
	public List<Company_eventDTO> company_eventList(int com_idx,int cp,int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("com_idx", com_idx);
		map.put("start", start);
		map.put("end", end);
		List<Company_eventDTO> eventList = Company_eventDao.company_eventList(map);
		return eventList;
	}
	
	@Override
	public int getEventTotalCnt(int com_idx) {
		int count = Company_eventDao.getEventTotalCnt(com_idx);
		count = count == 0?1:count;
		return count;
	}
	
	@Override
	public Company_eventDTO company_eventContent(int event_idx, int com_idx) {
		Map map = new HashMap();
		map.put("com_idx", com_idx);
		map.put("event_idx", event_idx);
		Company_eventDTO eventDto = Company_eventDao.company_eventContent(map);
		return eventDto;
	}
}