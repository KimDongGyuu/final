package com.ace.company_event.model;

import java.util.*;

public interface Company_eventDAO {
	
	public int company_eventWrite(Company_eventDTO eventDto);
	public List<Company_eventDTO> company_eventList(Map map);
	public int getEventTotalCnt(int event_idx);
	public Company_eventDTO company_eventContent(Map map);
}