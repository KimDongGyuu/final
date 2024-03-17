package com.ace.company_news.model;

import java.util.*;

public interface Company_newsDAO {

	public int company_newsWrite(Company_newsDTO dto);
	public List<Company_newsDTO> company_newsList(Map map);
	public int getTotalCnt();
	public Company_newsDTO company_newsContent(int news_idx);
	public int company_newsDelete(int news_idx);
	public Company_newsDTO company_newsUpdateForm(int news_idx);
	public int company_newsUpdate(Company_newsDTO dto);
	public int company_newsReadnumUpdate(int news_idx );
	public List<Company_newsDTO> company_newsSearch(String keyword);
}