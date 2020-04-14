package com.vfuchong.sptsm.common.exception;

/**
 * 获得旧版错误码
 */
public enum OldErrorCode {
    /**
     * 并发冲突异常
     */
    STALE_OBJECT_STATE_EXCEPTION("10", "版本冲突,数据已被其他事务修改"),

    /**
     * 服务器http请求异常
     */
    HTTP_REQUEST_ERROR("4003", "http request error, %s"),

    SOCKET_REQUEST_ERROR("21", "socket request error, %s"),

    CARDCONFIRM_NO_ACCESSCODE("101", "制卡回盘接口未分配AccessCode"),

    INVALID_DGI_DATA("103", "invalid %s DGI data: %s, cardNo: %s"),

    NOT_TERMINAL_BY_CITY("104", "invalid city code: %s"),

    HuaWeiDeleteCardException("105", "HuaWeiDeleteCardException: %s"),

    Yikatong_ReturnCardException("106", "Yikatong_ReturnCardException: %s"),

    STATUS_HAS_BEEN_UPDATED("107", "STATUS_HAS_BEEN_UPDATED: %s"),

    HUAWEI_REFRUND_EXCEPTION("108","Hauwei_refund_exception : %s"),

    YIKATONG_GET_BALANCE_INTERFACE_EXCEPTION("109","Yikatong_get_balance_exception : %s"),

    /**************华为Exception START*********************/
    /**
     * 华为Wallet服务器状态码定义start
     * 0	成功
     * 1	参数错误	进一步的信息可以查看返回说明。
     * 2	签名错误
     * 3	内部错误	各种无具体原因的处理异常等
     * 4	无权访问	比如白名单控制时，部分地址无权访问服务器或接口;或者商户无权访问某些资源，比如非华为商户不能进行充值调整等。
     * 5	操作失败	不区分具体原因的操作失败，进一步的信息可以通过描述获取。
     */
    OP_HUAWEI_PARAM_ERROR("1", "参数错误,%s为空"),
    OP_HUAWEI_SIGN_ERRO("2", "verify sign error"),
    OP_HUAWEI_INNER_ERROR("3", "system internal error, %s"),
    OP_HUAWEI_NO_RIGHT_ACCESS("4", "not allow access, %s"),
    OP_HUAWEI_HTTP_FAILED("5", "failure, %s"),

    HW_INSUFFICIENT_CARD_RESOURCES("1001", "insufficient card resources"),
    HW_ILLEGAL_CITY("1002", "seId[%s] [HW_ILLEGAL_CITY] cardCode is not found, ExternalCode[%s]"),
    HW_ORDER_DISSUPPORT_MOBILE_MODE("1005", "illegal device mode %s"),
    /**
     * 生成移除订单时，移除策略现在不满足。规定时间期限内， 同一卡号申请移除次数超过规定
     */
    HW_REMOVE_CHECK_BEYOND_LIMIT("1101", "beyond limit of remove count, cardno[%s]"),
    /**
     * 申请恢复订单时， 同一卡号存在未完成的恢复订单
     */
    HW_RESTORE_EXIST_UNHANDLED_ORDER("1201", "had unhandled order"),

    /**
     * 删卡
     */
    HW_CHECK_CARD_BALANCE_ERROR("5003","mac1校验失败"),

    /**
     * 个人化
     */
    // 非法订单
    HW_ILLEGAL_ORDER("3001", "订单不存在"),
    // 订单状态异常 未支付成功、订单已使用等
    HW_ORDER_EXCEPTION("3002", "订单状态异常，%s"),
    // 公交服务器异常
    HW_BUS_SERVER_EXCEPTION("3003", "公交服务器异常"),
    // 应用不存在
    HW_INSTANCE_NOT_EXIST("3004", "应用实例不存在"),

    /**
     * 公交卡移除条件检查
     * 11001: 目标aid选择失败
     * 11002: 读卡信息，指令执行失败
     * 11003: 移除条件检查，发现存在不满足的条件。
     * 11999: 系统异常
     */
    HW_CHECK_NOT_FOUND_AID("11001", "failed select aid[%s]"),
    HW_CHECK_APDU_EXECUTE_FAIL("11002", "apdu executed failed"),
    HW_CHECK_NOT_MEETING_CONDITION("11003", "移除条件不满足"),
    HW_CHECK_SYSTEM_ERROR("11004", "system error"),
    // 河北迁卡检查余额，超过5元返回此错误码
    HW_CHECK_BALANCE_OVER_RANGE("11006", "balance out of range"),
    /**
     * 公交卡信息备份
     * 12001: 目标aid选择失败。
     * 12002: 指令执行失败
     * 12999: 系统异常
     */
    HW_BACKUP_NOT_FOUND_AID("12001", "failed select aid[%s]"),
    HW_BACKUP_APDU_EXECUTE_FAIL("12002", "apdu executed failed"),
    HW_BACKUP_SYSTEM_ERROR("12999", "system error, %s"),
    /**
     * 卡片移除删卡&解绑
     * 13001: 指令执行没有完成后结果不符合预期
     * 13002: 卡片到通卡系统解绑失败
     * 13999: 系统异常
     */
    HW_REMOVE_APDU_EXECUTE_FAIL("13001", "delete of removeCard apdu executed failed"),
    HW_REMOVE_UNBIND_FAIL("13002", "apdu executed failed"),
    HW_REMOVE_SYSTEM_ERROR("13999", "system error"),
    /**
     * 公交卡恢复
     * 14001 指令执行没有完成后结果不符合预期
     * 14002 已个人化成功，不允许再发起个人化；数据已恢复
     * 14999 系统异常
     */
    HW_RESTORE_APDU_EXECUTE_FAIL("14001", "restore apdu executed failed[%s]"),
    HW_RESTORE_DUPLICATE("14002", "duplicate operation, card:%s had been restored"),
    HW_RESTORE_SYSTEM_ERROR("14999", "system error"),

    HW_SERVER_CLOSED("1009", "[CreateOrderHandler] card is closed, cardCode[%s] cardStatus[%s]"),

    HW_APDU_EXCUTE_EXCEPTION("6002", "APDU excuted failed"),
    HW_SECURITY_ERROR("6004", "seId[%s] Failed to process NWExtAuth with SD[%s]"),
    HW_DISSUPPORT_CITY("9001", "seId[%s] not support city ExternalCode[%s]"),
    HW_DISSUPPORT_MOBILE_MODE("9002", "seId[%s] not support mobile model[%s]"),
    // 激活请求失败
    HW_ACTIVATE_FAIL_EXCEPTION("3102", "card activated fail"),

    //河北账户充值成功后，获取MAC2失败
    HW_ERROR_ACC_RECHARGED("4006","seId[%s] acc_recharge success but get mac2 error"),
    /**************华为Exception END*********************/

    /**
     * 沈阳接口错误码
     */
    INCORRECT_PARAMETER("2001", "%s不正确"),

    INVOICE_RECEIVE("2002", "%s订单,不能重复领取发票"),

    /**
     * 201-300 通用异常代码段
     */
    MISSING_ARGS_ERROR("201", "missing params:%s"),

    SIGN_VERIFY_ERROR("202", "verify sign error"),

    NO_REGISTRY_PROCEDURE("-1", "[%s] had not registry [%s] process");


    /**
     * pm_business_opt_log操作表记录信息
     */
    private String message;
    /**
     * 异常描述，支持String.format格式
     */
    private String errorCode;

    OldErrorCode(String errorCode, String returnMsg) {
        this.message = errorCode;
        this.errorCode = returnMsg;
    }


}
