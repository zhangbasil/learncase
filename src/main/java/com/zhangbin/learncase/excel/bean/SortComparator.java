package com.zhangbin.learncase.excel.bean;

import com.zhangbin.learncase.excel.bean.inter.Sortable;

import java.util.Comparator;

public class SortComparator implements Comparator<Sortable>{

	private static SortComparator comparator;
	
	public int compare(Sortable o1, Sortable o2) {		
		return o1.getSort() - o2.getSort();
	}
	
	public static SortComparator getInstance(){
		return comparator == null ? new SortComparator() : comparator;
	}
}
