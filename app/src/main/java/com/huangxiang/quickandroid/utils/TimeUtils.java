/**
 * Copyright &copy; 2014-2016  All rights reserved.
 *
 * Licensed under the 深圳中盟燧石科技 License, Version 1.0 (the "License");
 * 
 */
package com.huangxiang.quickandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeUtils
 * @Description:
 * @author huangxiang
 * @date 2015-4-1 下午4:41:07
 */
public class TimeUtils {

	public static String transformToTime1(long time) {
		Date date = new Date(time);
		SimpleDateFormat mDateFormat = new SimpleDateFormat("MM/dd HH:mm");
		String timeString = mDateFormat.format(date);
		return timeString;
	}
	
	public static String transformToTime2(long time) {
		Date date = new Date(time);
		SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String timeString = mDateFormat.format(date);
		return timeString;
	}
}
