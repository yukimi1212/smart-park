package com.zucc.smart.domain;

import java.util.List;

public class TableInfo<T> {
    //数据库总行数
	private int total;
    //当前页的数据
	private List<T> rows;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
