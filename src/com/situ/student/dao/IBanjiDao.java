package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Banji;

public interface IBanjiDao {
	public abstract int add(String banji);
	public abstract int delete(Integer id);
	public abstract List<Banji> findAll();
	

}
