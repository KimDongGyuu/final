package com.ace.company_event.service;

import java.util.List;

import com.ace.company_event.model.Company_eventDTO;

public interface company_eventService {

	public int company_eventWrite(Company_eventDTO eventDto);
	public List<Company_eventDTO> company_eventList(int com_idx,int cp,int Ls);
	public int getEventTotalCnt(int com_idx);
	public Company_eventDTO company_eventContent(int event_idx , int com_idx);
}
