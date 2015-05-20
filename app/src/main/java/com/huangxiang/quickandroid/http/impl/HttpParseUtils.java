/**
 * Copyright &copy; 2014-2016  All rights reserved.
 *
 * Licensed under the 深圳中盟燧石科技 License, Version 1.0 (the "License");
 * 
 */
package com.huangxiang.quickandroid.http.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * @ClassName: HttpParseUtils
 * @Description: HTTP返回数据解析
 * @author huangxiang
 * @date 2015-3-11 下午4:11:51
 */
public class HttpParseUtils {
	/**
	 * 
	 * @Title: parseReturn
	 * @author huangxiang
	 * @Description: 解析任意类型返回
	 * @param jsonObject
	 * @param type
	 *            eg:Type type = new TypeToken<HttpResponse.BaseReturn>()
	 *            {}.getType();
	 * @return T 返回类型
	 * @throws
	 */
	public static <T> T parseReturn(JSONObject jsonObject, Type type) {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		T mReturn = gson.fromJson(jsonObject.toString(), type);
		return mReturn;
	}
}
