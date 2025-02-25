package com.fly.test.config;

import com.fly.test.constants.CommonConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty(value = "0-成功，1-失败")
	private int code;

	@Getter
	@Setter
	@ApiModelProperty(value = "失败时错误详细")
	private ErrorInfo error;

	@Getter
	@Setter
	@ApiModelProperty(value = "应答数据")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> failed() {
		return restResult(null, CommonConstants.FAIL, null);
	}

	public static <T> R<T> failed(String errorMsg) {
		ErrorInfo errorInfo = ErrorInfo.get(errorMsg);
		return restResult(null, CommonConstants.FAIL, errorInfo);
	}

	public static <T> R<T> failed(String erorrCode, String errorMsg) {
		ErrorInfo errorInfo = ErrorInfo.get(erorrCode, errorMsg);
		return restResult(null, CommonConstants.FAIL, errorInfo);
	}
	
	public static <T> R<T> failed(ErrorInfo errorInfo) {
		return restResult(null, CommonConstants.FAIL, errorInfo);
	}
	
	private static <T> R<T> restResult(T data, int code, ErrorInfo errorInfo) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setError(errorInfo);
		return apiResult;
	}

}
