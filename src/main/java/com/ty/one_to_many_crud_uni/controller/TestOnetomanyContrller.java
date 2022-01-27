package com.ty.one_to_many_crud_uni.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.one_to_many_crud_uni.dao.OrderDao;
import com.ty.one_to_many_crud_uni.dto.AmazonOrder;
import com.ty.one_to_many_crud_uni.dto.Items;

public class TestOnetomanyContrller {

	public static void main(String[] args) {

		OrderDao orderDao = new OrderDao();

		Items item=new Items();
		Items item2=new Items();
		Items item3=new Items();
		Items item4=new Items();
		List<Items> items=new ArrayList<Items>();
		List<Items> items2=new ArrayList<Items>();
		AmazonOrder amazonOrder=new AmazonOrder();
		AmazonOrder amazonOrder2=new AmazonOrder();
		amazonOrder.setAddress("mine");
		amazonOrder.setId(3);
		amazonOrder.setItems(items);
		amazonOrder2.setAddress("yours");
		amazonOrder2.setId(4);
		amazonOrder2.setItems(items2);
		item.setId(5);
		item2.setId(6);
		item3.setId(7);
		item4.setId(8);
		item.setName("pads");
		item2.setName("shoes");
		item3.setName("gloves");
		item4.setName("sticker");
		item.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder2);
		item4.setAmazonOrder(amazonOrder2);
		items.add(item);
		items.add(item2);
		items2.add(item3);
		items2.add(item4);
		
		orderDao.saveOrder(amazonOrder);
		orderDao.saveOrder(amazonOrder2);
		//manyUni.deleteOrder(2);
	}
}
