package com.fly.test.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;

@Data
@Component
public class RestTemplateUtil {

	private static RestTemplateUtil restTemplateUtil = null;

	@Resource
	private RestTemplate restTemplate;

	@PostConstruct
	public void init() {
		restTemplateUtil = this;
	}

	public static HttpHeaders toHttpHeader(Map<String, String> headers) {
		HttpHeaders httpHeader = new HttpHeaders();
		if (MapUtil.isNotEmpty(headers)) {
			if (MapUtil.isNotEmpty(headers)) {
				headers.forEach((k, v) -> {
					httpHeader.add(k, StrUtil.blankToDefault(v, ""));
				});
			}
		}
		return httpHeader;
	}

	public static ResponseEntity<Void> doGet(boolean isHealth, UrlBuilder builder, Map<String, String> headers) {
		return doGet(isHealth, builder, headers, Void.class);
	}

	public static <T> ResponseEntity<T> doGet(boolean isHealth, UrlBuilder builder, Map<String, String> headers, Class<T> rspClass) {
		builder.setWithEndTag(false);
		URI uri = builder.toURI();
		try {
			HttpHeaders httpHeader = toHttpHeader(headers);
			HttpEntity<Void> entity = new HttpEntity<>(httpHeader);
			return restTemplateUtil.getRestTemplate().exchange(uri, HttpMethod.GET, entity, rspClass);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static ResponseEntity<String> doPost(boolean isHealth, UrlBuilder builder, String jsnoBody, Map<String, String> headers) {
		HttpHeaders httpHeaders = toHttpHeader(headers);
		HttpEntity<String> requestEntity = new HttpEntity<String>(jsnoBody, httpHeaders);
		return doPost(isHealth, builder, requestEntity, String.class);
	}

	public static <T> ResponseEntity<T> doPost(boolean isHealth, UrlBuilder builder, String jsnoBody, Map<String, String> headers, Class<T> rspClass) {
		HttpHeaders httpHeaders = toHttpHeader(headers);
		HttpEntity<String> requestEntity = new HttpEntity<String>(jsnoBody, httpHeaders);
		return doPost(isHealth, builder, requestEntity, rspClass);
	}

	public static <T> ResponseEntity<T> doPost(boolean isHealth, UrlBuilder builder, HttpEntity<?> requestEntity, Class<T> rspClass) {
		builder.setWithEndTag(false);
		try {
			return restTemplateUtil.getRestTemplate().postForEntity(builder.toURI(), requestEntity, rspClass);
		}  catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static <T> ResponseEntity<T> execute(boolean isHealth, RequestEntity<?> requestEntity, Class<T> rspClass) {
		try {
			return restTemplateUtil.getRestTemplate().exchange(requestEntity, rspClass);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static <T> ResponseEntity<T> execute(boolean isHealth, RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) {
		try {
			return restTemplateUtil.getRestTemplate().exchange(requestEntity, responseType);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static ResponseEntity<String> execute(boolean isHealth, RequestEntity<?> requestEntity) {
		return execute(isHealth, requestEntity, String.class);
	}
}
