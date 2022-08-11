package com.foway.mason.dao;

import java.util.List;

import com.foway.mason.vo.OrderMainFile;

public interface OrderMainFileDao {
	OrderMainFile insert(OrderMainFile orderMainFileHibernate);
	Integer selectorderserialnumber();
}