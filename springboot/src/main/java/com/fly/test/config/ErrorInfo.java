package com.fly.test.config;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ErrorInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty(value = "错误码")
	private String code;

	@Getter
	@Setter
	@ApiModelProperty(value = "错误分类")
	private String group;

	@Getter
	@Setter
	@ApiModelProperty(value = "应答错误信息")
	private String message;

	public static ErrorInfo get(String code, String message) {
		ErrorInfo info = new ErrorInfo();
		info.setCode(code);
		info.setGroup(genErrorGroup(code));
		info.setMessage(message);
		return info;
	}

	public static ErrorInfo get(String message) {
		ErrorInfo info = new ErrorInfo();
		info.setCode("E20000");
		info.setGroup(genErrorGroup(info.getCode()));
		info.setMessage(message);
		return info;
	}

	private static String genErrorGroup(String errorCode) {
		try {
			String subPre = StrUtil.subPre(errorCode, 3);
			String errorClassify = "test";
			return errorClassify;
		} catch (Exception e) {
			return "系统未知错误类型";
		}
	}

}
