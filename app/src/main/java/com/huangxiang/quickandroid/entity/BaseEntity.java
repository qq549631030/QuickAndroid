/**
 * Copyright &copy; 2014-2016  All rights reserved.
 *
 * Licensed under the 深圳中盟燧石科技 License, Version 1.0 (the "License");
 * 
 */
package com.huangxiang.quickandroid.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;

/**
 * @ClassName: BaseEntity
 * @Description:
 * @author huangxiang
 * @date 2015-3-17 下午5:47:14
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 8792609903342691514L;
	@DatabaseField(id = true)
	private int id;
	@DatabaseField
	private long createTime;
	@DatabaseField
	private long updateTime;
	@DatabaseField
	private int isDeleted;

	public BaseEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

}
