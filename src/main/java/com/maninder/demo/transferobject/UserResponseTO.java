package com.maninder.demo.transferobject;

import java.io.Serializable;
import java.util.List;

public class UserResponseTO implements Serializable {

	private List<UserTO> users;
	private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public List<UserTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserTO> users) {
		this.users = users;
	}
	
	
	
	
    
    
	
	
}
