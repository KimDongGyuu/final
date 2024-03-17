package com.ace.company_news.model;

import java.util.*;


import org.mybatis.spring.SqlSessionTemplate;

public class Company_newsDAOImple implements Company_newsDAO {

	private SqlSessionTemplate sqlmap;
	
	public Company_newsDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public int company_newsWrite(Company_newsDTO dto) {
		int count = sqlmap.insert("company_newsWrite" , dto);
		return count;
	}
	
	@Override
	public List<Company_newsDTO> company_newsList(Map map) {
		List<Company_newsDTO> list = sqlmap.selectList("company_newsList",map);
		return list;
	}
	
	@Override
	public List<Company_newsDTO> company_newsSearch(String keyword) {
		List<Company_newsDTO> list = sqlmap.selectList("company_newsSearch",keyword);
		return list;
	}
	
	@Override
	public int getTotalCnt() {
		int count = sqlmap.selectOne("totalCnt");
		return count;
	}
	
	@Override
	public Company_newsDTO company_newsContent(int news_idx) {
		Company_newsDTO dto = sqlmap.selectOne("company_newsContent",news_idx);
		
		return dto;
	}
	
	@Override
	public int company_newsDelete(int news_idx) {
		int count = sqlmap.delete("company_newsDelete",news_idx);
		return count;
	}
	
	@Override
	public Company_newsDTO company_newsUpdateForm(int news_idx) {
		Company_newsDTO dto = sqlmap.selectOne("company_newsUpdateForm",news_idx);
		return dto;
	}
	
	@Override
	public int company_newsUpdate(Company_newsDTO dto) {
		int count = sqlmap.delete("company_newsUpdate",dto);
		return count;
	}
	
	@Override
	public int company_newsReadnumUpdate(int news_idx) {
		int count = sqlmap.update("company_newsReadnumUpdate",news_idx);
		return count;
	}
}






