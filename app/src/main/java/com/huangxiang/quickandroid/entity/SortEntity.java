/**
 * Copyright &copy; 2014-2016  All rights reserved.
 *
 * Licensed under the 深圳中盟燧石科技 License, Version 1.0 (the "License");
 * 
 */
package com.huangxiang.quickandroid.entity;

import com.j256.ormlite.field.DatabaseField;

/**
 * @ClassName: SortEntity
 * @Description:
 * @author huangxiang
 * @date 2015-3-17 下午5:59:08
 */
public class SortEntity extends BaseEntity {
	@DatabaseField
	private int order;

	public SortEntity() {
		super();
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
