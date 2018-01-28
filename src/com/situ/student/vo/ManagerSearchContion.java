package com.situ.student.vo;

public class ManagerSearchContion {
	private Integer pageNo;
	private Integer pageSize;
	private String studentName;
	private String banjiName;
	private String courseName;
	
	
	public ManagerSearchContion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerSearchContion(Integer pageNo, Integer pageSize, String studentName, String banjiName,
			String courseName) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.studentName = studentName;
		this.banjiName = banjiName;
		this.courseName = courseName;
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBanjiName() {
		return banjiName;
	}
	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "ManagerSearchContion [pageNo=" + pageNo + ", pageSize=" + pageSize + ", studentName=" + studentName
				+ ", banjiName=" + banjiName + ", courseName=" + courseName + "]";
	}
	
	

}
