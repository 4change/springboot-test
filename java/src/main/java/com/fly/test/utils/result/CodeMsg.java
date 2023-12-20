package com.fly.test.utils.result;

public class CodeMsg {

    private int code;
    private String msg;

    // 通用异常 X
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(1, "服务端异常");
    public static CodeMsg PARAMETER_ERROR = new CodeMsg(2, "参数异常");
    public static CodeMsg PARAMETER_TOO_LITTLE = new CodeMsg(3, "参数过少，结果集过大，建议增加参数");
    public static CodeMsg IMATRIX_TOKEN_ERROR = new CodeMsg(4, "IMATRIX TOKEN错误或无对应TOKEN");
    public static CodeMsg IMATRIX_TOKEN_NULL = new CodeMsg(5, "IMATRIX TOKEN为空");

    // CRUD 1X
    public static CodeMsg INSERT_FAIL = new CodeMsg(11, "插入失败");
    public static CodeMsg DELETE_FAIL = new CodeMsg(12, "删除失败");
    public static CodeMsg UPDATE_FAIL = new CodeMsg(13, "更新失败");
    public static CodeMsg SELECT_FAIL = new CodeMsg(14, "查询失败");
    public static CodeMsg SELECT_NONE = new CodeMsg(15, "查询数据为空");
    public static CodeMsg DELETE_NONE = new CodeMsg(16, "删除失败,无对应记录");

    // 用户模块 2X
    public static CodeMsg AUTH_FAIL = new CodeMsg(21, "用户授权失败");
    public static CodeMsg USER_NONE = new CodeMsg(22, "无对应用户或无对应微信id");
    public static CodeMsg WXID_NONE = new CodeMsg(22, "获取用户微信id为空");

    // 股票模块 3X
    public static CodeMsg STOCKINPOOL_NONE = new CodeMsg(31, "股票池中无对应股票记录");

    // 股票池模块 4X
    public static CodeMsg DUPLICATE_NAME = new CodeMsg(41, "股票池名字重复");
    public static CodeMsg STOCKPOOL_NONE = new CodeMsg(42, "无对应股票池");
    public static CodeMsg STOCKPOOL_NOT_BELONG_TO_USER = new CodeMsg(42, "股票池不属于用户");

    // 策略池模块 5X
    public static CodeMsg STRATEGY_SET_DUPLICATE_NAME = new CodeMsg(51, "策略集名字重复");

    // 组合模块 6X
    public static CodeMsg PORTFOLIO_NONE = new CodeMsg(61, "无对应组合");
    public static CodeMsg PORTFOLIO_EXPIRED = new CodeMsg(62, "该用户名下该组合已过期");
    public static CodeMsg PORTFOLIO_ACCESS_DENY = new CodeMsg(63, "用户尚未兑换该组合");

    // 模式模块 7X
    public static CodeMsg PATTERN_NAME_DUPLICATE = new CodeMsg(71, "模式名重复");
    public static CodeMsg PATTERN_DUPLICATE = new CodeMsg(72, "模式重复,请修改股票代码、窗口开始时间、窗口结束时间、匹配类型、匹配周期其中之一条件");

    // 积分模块 ８X
    public static CodeMsg DUPLICATE_SIGN_IN = new CodeMsg(81, "用户已签到，请勿重复签到");
    public static CodeMsg TOO_LILLTE_TO_EXCHANGE = new CodeMsg(82, "用户积分不足以兑换该组合");


    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
