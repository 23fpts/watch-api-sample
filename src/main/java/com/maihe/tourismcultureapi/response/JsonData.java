package com.maihe.tourismcultureapi.response;

import java.io.Serializable;

/**
 * @Author 姜立
 * 
 * @Description:响应实体类
 * 
 * @CreateTime:2019/12/20
 *
 */
public class JsonData implements Serializable {

	private static final long serialVersionUID = 1L;

	// 状态码（0表示成功）
	private Integer code;

	// 数据
	private Object data;

	// 错误提示
	private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JsonData(Integer code, Object data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	// 成功，不传入数据
	public static JsonData buildSuccess() {
		return new JsonData(0, null, null);
	}

	// 成功，传入数据
	public static JsonData buildSuccess(Object data) {
		return new JsonData(0, data, null);
	}

	// 失败，传入消息
	public static JsonData buildError(String msg) {
		return new JsonData(1, null, msg);
	}
}
