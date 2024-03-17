package com.ace.controller;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ace.company_news.model.Company_newsDTO;
import com.ace.company_news.model.FileUploadDTO;
import com.ace.company_news.service.company_newsService;


@Controller
public class Company_newsController {

@Autowired
private company_newsService company_newsService; 
	
	@RequestMapping("/company_news_List.do")
	public ModelAndView company_newsList(@RequestParam(value = "cp", defaultValue = "1") int cp) {
		
		int totalCnt = company_newsService.getTotalCnt();
		int listSize = 10;
		int pageSize = 5;
		
		String pageStr = com.ace.page.pageMaker.makePage("company_news_List.do", totalCnt, listSize, pageSize, cp);
		
		List<Company_newsDTO> list = company_newsService.company_newsList(cp,listSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",list);
		mav.addObject("pageStr",pageStr);
		mav.setViewName("company_news/company_news_List");
		return mav;
	}
	
	@RequestMapping("/company_newsSearch.do")
	public ModelAndView company_newsSearch(@RequestParam("keyword")String keyword) {
		List<Company_newsDTO> list = company_newsService.company_newsSearch(keyword);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",list);
		mav.setViewName("company_news/company_news_Search");
		return mav;
	}
	
	@RequestMapping(value="/company_news_Writeform.do" , method = RequestMethod.GET)
	public String company_news_Writeform() {
		return "company_news/company_news_Writeform";
	}
	
	@RequestMapping("/company_newsWrite.do")
	public ModelAndView company_newsWrite(Company_newsDTO dto) {

		int result = company_newsService.company_newsWrite(dto);
		String msg = result > 0? "게시물이 등록 되었습니다.":"게시물 등록에 실패 하였습니다.";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", msg);
		mav.setViewName("company_news/company_newsMsg");
		return mav;
	}
	@RequestMapping("/company_news_Content.do")
	public ModelAndView company_newsContent(@RequestParam("news_idx") Integer news_idx) {
		Company_newsDTO dto = company_newsService.company_newsContent(news_idx);
		
		int result = company_newsService.company_newsReadnumUpdate(news_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.addObject("result",result);
		mav.setViewName("company_news/company_news_Content");
		return mav;
	}
	
	@RequestMapping("/company_news_Delete.do")
	public ModelAndView company_newsDelete(@RequestParam("news_idx")int news_idx) {
		int result = company_newsService.company_newsDelete(news_idx);
		String msg = result > 0? "게시물이 삭제 되었습니다.":"게시물 삭제에 실패 하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("company_news/company_newsMsg");
		return mav;
	}
	
	@RequestMapping("/company_news_UpdateForm.do")
	public ModelAndView company_newsUpdateForm(@RequestParam("news_idx")int news_idx) {
		Company_newsDTO dto = company_newsService.company_newsUpdateForm(news_idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("company_news/company_news_UpdateForm");
		return mav;
	}
	
	@RequestMapping("/company_newsUpdate.do")
	public ModelAndView companu_newsUpdate(Company_newsDTO dto) {
	int result = company_newsService.company_newsUpdate(dto);
	String msg = result>0?"게시글이 수정되었습니다.":"게시글 수정에 실패 하였습니다.";
	
	ModelAndView mav = new ModelAndView();
	mav.addObject("msg",msg);
	mav.setViewName("company_news/company_newsMsg");
	return mav;
	}
	
	@RequestMapping("/fileUploadForm.do")
	public String fileUploadForm() {
		return "company_news/fileUploadForm";
	}
	
	@RequestMapping("/fileUpload.do")
	public String fileUpload(FileUploadDTO dto) {
		copyInto(dto.getNews_file());
		return "company_news/fileOk";
	}
	
	/**파일복사 메서드*/
	public void copyInto(MultipartFile news_file) {
		System.out.println("파일명 : "+news_file.getOriginalFilename());
		
		try {
			byte bytes[] = news_file.getBytes(); //원본
			File f = new File("C:/JavaStudy/upload/"+news_file.getOriginalFilename()); //빈 종이 
			FileOutputStream fos = new FileOutputStream(f); //복사기에 빈종이 삽입
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}







