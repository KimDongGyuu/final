package com.ace.company_news.service;

import java.util.*;

import com.ace.company_news.model.Company_newsDAO;
import com.ace.company_news.model.Company_newsDTO;

public class company_newsServiceImple implements company_newsService {

	private Company_newsDAO company_newsDao;



	public Company_newsDAO getCompany_newsDao() {
		return company_newsDao;
	}



	public void setCompany_newsDao(Company_newsDAO company_newsDao) {
		this.company_newsDao = company_newsDao;
	}



	@Override
	public int company_newsWrite(Company_newsDTO dto) {
		int count = company_newsDao.company_newsWrite(dto);
		return count;
	}
	
	@Override
	public List<Company_newsDTO> company_newsList(int cp,int ls) {
		int start = (cp-1)*ls+1;
		int end = cp*ls;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<Company_newsDTO> list = company_newsDao.company_newsList(map);
		return list;
	}
	
	@Override
	public List<Company_newsDTO> company_newsSearch(String keyword) {

		List<Company_newsDTO> list = company_newsDao.company_newsSearch(keyword);
		return list;
	}
	
	@Override
	public int getTotalCnt() {
		int count = company_newsDao.getTotalCnt();
		count = count == 0?1:count;
		return count;
	}
	
	@Override
	public Company_newsDTO company_newsContent(int news_idx) {
		Company_newsDTO dto = company_newsDao.company_newsContent(news_idx);
		return dto;
		
	}
	
	@Override
	public int company_newsDelete(int news_idx) {
		int count = company_newsDao.company_newsDelete(news_idx);
		return count;
	}
	
	@Override
	public Company_newsDTO company_newsUpdateForm(int news_idx) {
		Company_newsDTO dto = company_newsDao.company_newsUpdateForm(news_idx);
		return dto;
	}
	
	@Override
	public int company_newsUpdate(Company_newsDTO dto) {
		int count = company_newsDao.company_newsUpdate(dto);
		return count;
	}
	
	@Override
	public int company_newsReadnumUpdate(int news_idx) {
		int count = company_newsDao.company_newsReadnumUpdate(news_idx);
		return count;
	}
}





