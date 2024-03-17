package com.ace.company_news.service;

import java.util.List;

import com.ace.company_news.model.Company_newsDTO;

public interface company_newsService {

	public int company_newsWrite(Company_newsDTO dto);
	public List<Company_newsDTO> company_newsList(int cp,int Ls);
	public int getTotalCnt();
	public Company_newsDTO company_newsContent(int news_idx);
	public int company_newsDelete(int news_idx);
	public Company_newsDTO company_newsUpdateForm(int news_idx);
	public int company_newsUpdate(Company_newsDTO dto);
	public int company_newsReadnumUpdate(int news_idx );
	public List<Company_newsDTO> company_newsSearch(String keyword);
}