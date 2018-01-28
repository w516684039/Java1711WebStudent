package com.situ.student.vo;

public class CourseSearchCondition {
	private String name;
	private Integer pageNo;
	private Integer pageSize;
	
	public CourseSearchCondition() {
		super();
	}
	public CourseSearchCondition(String name, Integer pageNo, Integer pageSize) {
		super();
		this.name = name;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	@Override
	public String toString() {
		return "CourseSearchCondition [name=" + name + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}
	

}
