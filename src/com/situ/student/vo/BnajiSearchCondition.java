package com.situ.student.vo;

public class BnajiSearchCondition {
	private Integer pageNo;
	private Integer pageSize;
	private String name;
	
	
	
	public BnajiSearchCondition() {
		super();
	}
	public BnajiSearchCondition(Integer pageNo, Integer pageSize, String name) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BnajiSearchCondition [pageNo=" + pageNo + ", pageSize=" + pageSize + ", name=" + name + "]";
	}
	

}
