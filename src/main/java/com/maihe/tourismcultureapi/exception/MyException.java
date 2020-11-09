package com.maihe.tourismcultureapi.exception;

/**
 * @Author 姜立
 * 
 * @Description:自定义异常实体类
 * 
 * @CreateTime:2019/12/20
 *
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @param code 状态码
	 * @param msg 提示信息
	 * @return
	 */
	public MyException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}