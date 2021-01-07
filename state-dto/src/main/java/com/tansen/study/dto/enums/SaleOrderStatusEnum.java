/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.dto.enums;

/**
 * 销售单事件
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
public enum SaleOrderStatusEnum {
    WAITING_PAY(1000, "待支付"),

    WAITING_AUDIT(1010, "待审核"),

    WAITING_DELIVERY(1020, "待发货"),

    DELIVERED(1030, "待收货"),

    FINISHED(1040, "已完成"),

    CANCELED_BEFORE_PAY(1050, "未支付取消"),

    CANCELED_AFTER_PAY(1060, "已支付取消"),

    AUDIT_FAIL(1070, "审核不通过"),

    CANCELED_BEFORE_DELIVERY(1080, "未出库取消");

    /**
     * 状态编码
     */
    private int code;

    /**
     * 状态名称
     */
    private String name;


    SaleOrderStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SaleOrderStatusEnum getByCode(int code) {
        for (SaleOrderStatusEnum value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static String getNameByCode(int code) {
        for (SaleOrderStatusEnum value : values()) {
            if (value.getCode() == code) {
                return value.getName();
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
