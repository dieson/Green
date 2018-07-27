package com.dieson.green.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @ClassName: PageBean
 * @Description: 分页数据
 * @author: Dieson Zuo
 * @date: 2018年7月25日 上午11:13:00
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PageBean<T> implements Serializable {
	/**
	 * 当前页
	 */
	private Integer currentPage;
	/**
	 * 每页显示条数
	 */
	private Integer pageSize;
	/**
	 * 总记录数
	 */
	private Integer totalCount;

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the content
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}

	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 每页数据内容
	 */
	private List<T> content;

}
