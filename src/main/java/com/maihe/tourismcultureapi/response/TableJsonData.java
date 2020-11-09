package com.maihe.tourismcultureapi.response;

import java.io.Serializable;

/**
 * @Author 姜立
 * 
 * @Description:表格数据响应实体类
 * 
 * @CreateTime:2019/12/20
 *
 */
public class TableJsonData implements Serializable {

	private static final long serialVersionUID = 1L;

	// 状态码（0表示成功）
	private Integer code;

	// 表格数据
	private Object data;

	// 错误提示
	private String msg;

	// 数据总条数
	private Long count;

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

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public TableJsonData(Integer code, Object data, String msg, Long count) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.count = count;
	}

	// 成功，传入数据
	public static TableJsonData buildSuccess(Object data, Long count) {
		return new TableJsonData(0, data, null, count);
	}
}
