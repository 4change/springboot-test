package com.fly.test.constants;

public interface CommonConstants {

	/**
	 * 删除
	 */
	String STATUS_DEL = "1";

	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 机构树根节点
	 */
	String DEPT_TREE_ROOT_ID = "0";

	/**
	 * 菜单树根节点
	 */
	String MENU_TREE_ROOT_ID = "-1";

	/**
	 * 菜单
	 */
	String MENU = "0";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;

	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

	/**
	 * 当前页
	 */
	String CURRENT = "current";

	/**
	 * size
	 */
	String SIZE = "size";

	/**
	 * 平台租户类型
	 */
	String BAP_TENANT_TYPE = "1";

	/**
	 * 平台租户编号
	 */
	String BAP_TENANT_ID = "1";

	/**
	 * 租户类型字典编号
	 */
	String DIC_ID = "3";


	/**
	 * 暂停（无效）
	 */
	String STATUS_PAUSE = "1";

	/**
	 * 启用（有效）
	 */
	String STATUS_USE = "0";

	/**
	 * 菜单类型（菜单）
	 */
	String MENU_TYPE_MENU = "0";

	/**
	 * 菜单类型（按钮）
	 */
	String MENU_TYPE_BUTTON = "1";

	/**
	 * 合约描述长度限制
	 */
	Integer CONTRACT_DESC_LENGTH_LIMIT = 200;

}
