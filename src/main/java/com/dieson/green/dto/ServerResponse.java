package com.dieson.green.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.dieson.green.common.ResponseCode;

//保证序列化json的时候,如果是null的对象,key也会消失
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

	private int code;
	private String msg;
	private T data;

	private ServerResponse(int code) {
		this.code = code;
	}

	private ServerResponse(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private ServerResponse(int code, T data) {
		this.code = code;
		this.data = data;
	}

	private ServerResponse(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	// 当我的T 是String类型的情况下该如何处理.
	// 下列静态方法搞定

	// 在序列化时,不会序列化到json里
	@JsonIgnore
	public boolean isSuccess() {
		return this.code == ResponseCode.SUCCESS.getCode();
	}

	public int getCode() {
		return code;
	}

	public T getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	// 成功
	public static <T> ServerResponse<T> createBySuccess() {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}

	public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static <T> ServerResponse<T> createBySuccess(T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
	}

	public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	// 失败
	public static <T> ServerResponse<T> createByError() {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
	}

	public static <T> ServerResponse<T> createByErrorMesssage(String errorMessage) {
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse<T>(errorCode, errorMessage);
	}
}