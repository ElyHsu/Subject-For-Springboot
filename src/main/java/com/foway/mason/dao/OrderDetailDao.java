package com.foway.mason.dao;

import java.io.Serializable;

import com.foway.mason.vo.OrderDetail;

public interface OrderDetailDao {

	Serializable insert(OrderDetail vo);

}