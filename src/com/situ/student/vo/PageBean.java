package com.situ.student.vo;

import java.util.List;

import com.situ.student.entity.Student;

public class PageBean {
	private Integer pageNo;
	private Integer pageSize;
	private Integer tolalCount;
	private Integer totalPage;
    private List<Student> list;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTolalCount() {
		return tolalCount;
	}
	public void setTolalCount(Integer tolalCount) {
		this.tolalCount = tolalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageSize=" + pageSize + ", tolalCount=" + tolalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	} 
	
	
	
	
	
}
