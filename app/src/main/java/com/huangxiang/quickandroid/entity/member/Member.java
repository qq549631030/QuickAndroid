/**
 * Copyright &copy; 2014-2016  All rights reserved.
 *
 * Licensed under the 深圳中盟燧石科技 License, Version 1.0 (the "License");
 * 
 */
package com.huangxiang.quickandroid.entity.member;

import com.huangxiang.quickandroid.entity.BaseEntity;
import com.j256.ormlite.field.DatabaseField;

/**
 * @ClassName: Member
 * @Description:用户信息
 * @author huangxiang
 * @date 2015-3-17 下午5:50:45
 */
public class Member extends BaseEntity {

	@DatabaseField
	private String userName;// 用户名
	@DatabaseField
	private String password;// 密码
	@DatabaseField
	private String payPassword;// 支付密码
	@DatabaseField
	private String type;
	@DatabaseField
	private String mobile;// 手机号码
	@DatabaseField
	private String sinaMicroblog;
	@DatabaseField
	private String avatar;// 头像
	@DatabaseField
	private String nickName;// 昵称
	@DatabaseField
	private String signature;// 个性签名
	@DatabaseField
	private String province;// 省
	@DatabaseField
	private String city;// 市
	@DatabaseField
	private String county;// 区
	@DatabaseField
	private String address;// 地址
	@DatabaseField
	private String sex;// 性别
	@DatabaseField
	private String twoDimensionCode;
	@DatabaseField
	private String hobbies;// 兴趣爱好
	@DatabaseField
	private String bak1;
	@DatabaseField
	private String qq;
	@DatabaseField
	private String mail;// 邮箱
	@DatabaseField
	private String tencentMicroblog;
	@DatabaseField
	private String creator;
	@DatabaseField
	private String invitationCode;
	@DatabaseField
	private String bak2;

	@DatabaseField
	private int myJoinCircleCount;// 我加入的圈子数
	@DatabaseField
	private int myJoinFunCount;// 我参加的活动数
	@DatabaseField
	private int myInitiateFunCount;// 我发起的活动数
	@DatabaseField
	private int cafeCoinNumber;// 咖豆数量

	/**
	 * 仅圈子成员有以下字段
	 */
	private int flag;// 成员类型

	private String circleNickName;// 圈昵称

	private int isModifyCard;// 是否允许管理员修改我的圈名片

	private int isReceiveMsg;// 是否接收消息

	public Member() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSinaMicroblog() {
		return sinaMicroblog;
	}

	public void setSinaMicroblog(String sinaMicroblog) {
		this.sinaMicroblog = sinaMicroblog;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTwoDimensionCode() {
		return twoDimensionCode;
	}

	public void setTwoDimensionCode(String twoDimensionCode) {
		this.twoDimensionCode = twoDimensionCode;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTencentMicroblog() {
		return tencentMicroblog;
	}

	public void setTencentMicroblog(String tencentMicroblog) {
		this.tencentMicroblog = tencentMicroblog;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public int getMyJoinCircleCount() {
		return myJoinCircleCount;
	}

	public void setMyJoinCircleCount(int myJoinCircleCount) {
		this.myJoinCircleCount = myJoinCircleCount;
	}

	public int getMyJoinFunCount() {
		return myJoinFunCount;
	}

	public void setMyJoinFunCount(int myJoinFunCount) {
		this.myJoinFunCount = myJoinFunCount;
	}

	public int getMyInitiateFunCount() {
		return myInitiateFunCount;
	}

	public void setMyInitiateFunCount(int myInitiateFunCount) {
		this.myInitiateFunCount = myInitiateFunCount;
	}

	public int getCafeCoinNumber() {
		return cafeCoinNumber;
	}

	public void setCafeCoinNumber(int cafeCoinNumber) {
		this.cafeCoinNumber = cafeCoinNumber;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getCircleNickName() {
		return circleNickName;
	}

	public void setCircleNickName(String circleNickName) {
		this.circleNickName = circleNickName;
	}

	public int getIsModifyCard() {
		return isModifyCard;
	}

	public void setIsModifyCard(int isModifyCard) {
		this.isModifyCard = isModifyCard;
	}

	public int getIsReceiveMsg() {
		return isReceiveMsg;
	}

	public void setIsReceiveMsg(int isReceiveMsg) {
		this.isReceiveMsg = isReceiveMsg;
	}

}
