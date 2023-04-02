package com.example.segurityapp.payloads;

import java.util.List;
import com.example.segurityapp.dto.EntrantDto;

public class EntrantResponse {

	private List<EntrantDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements; // total records
	private int totalPages; // total pages as per calculation of records
	private boolean lastPage;

	public EntrantResponse() {

	}

	public List<EntrantDto> getContent() {
		return content;
	}

	public void setContent(List<EntrantDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
}
