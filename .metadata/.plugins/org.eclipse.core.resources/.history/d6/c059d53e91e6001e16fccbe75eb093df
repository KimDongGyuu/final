package com.ace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ace.company_event.model.Company_eventDTO;
import com.ace.company_event.service.company_eventService;

@Controller
public class Company_eventController {
	
	@Autowired
	private company_eventService company_eventService; 
	
	@RequestMapping("/company_event_List.do")
	public ModelAndView company_eventList(@RequestParam("com_idx")int com_idx,@RequestParam(value = "cp", defaultValue = "1") int cp) {
		
		int totalCnt = company_eventService.getEventTotalCnt(com_idx);
		int listSize = 10;
		int pageSize = 5;
		
		String pageStr = com.ace.page.company_eventListPage.makePage("company_event_List.do", totalCnt, listSize, pageSize, cp, com_idx);
		
		List<Company_eventDTO> eventList = company_eventService.company_eventList(com_idx, cp, listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("com_idx",com_idx);
		mav.addObject("eventList",eventList);
		mav.addObject("pageStr",pageStr);
		mav.setViewName("company_event/company_event_List");
		return mav;
	}
	
	@RequestMapping("/company_event_Writeform.do")
	public String company_event_Writeform() {
		return "company_event/company_event_WriteForm";
	}
	
	@RequestMapping("/company_eventWrite.do")
	public ModelAndView company_eventWrite(Company_eventDTO eventDto) {
		int result = company_eventService.company_eventWrite(eventDto);
		String msg = result > 0? "게시물이 등록 되었습니다.":"게시물 등록에 실패 하였습니다.";
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", msg);
		mav.setViewName("company_event/company_eventMsg");
		return mav;
	}
	
	@RequestMapping("/company_event_Content")
	public ModelAndView company_eventContent(@RequestParam("event_idx") Integer event_idx,@RequestParam("com_idx") Integer com_idx) {
		Company_eventDTO eventDto = company_eventService.company_eventContent(event_idx,com_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventDto",eventDto);
		mav.addObject("com_idx",com_idx);
		mav.addObject("event_idx",event_idx);
		mav.setViewName("company_event/company_event_Content");
		return mav;
	}
}
