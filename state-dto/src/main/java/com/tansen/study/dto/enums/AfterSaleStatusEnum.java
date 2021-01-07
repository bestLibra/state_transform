/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.dto.enums;

/**
 * 售后状态
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
public enum AfterSaleStatusEnum {
    WAITING_AUDIT(2010, "待审核"),

    WAITING_SEND_BACK(2020, "待寄回"),

    WAITING_STORAGE(2030, "待收货"),

    WAITING_REFUND(2040, "待退款"),

    REFUNDING(2050, "退款中"),

    FINISHED(2060, "已完成"),

    REJECT_AUDIT(2070, "审核不通过"),

    REJECT_STORAGE(2080, "拒绝收货"),

    REFUND_FAIL(2090, "退款异常"),

    CANCELED(2100, "已取消");

    /**
     * 状态编码
     */
    private int code;

    /**
     * 状态名称
     */
    private String name;


    AfterSaleStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static AfterSaleStatusEnum getByCode(int code) {
        for (AfterSaleStatusEnum value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (AfterSaleStatusEnum statusEnum : AfterSaleStatusEnum.values()) {
            if (code == statusEnum.code) {
                return statusEnum.getName();
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
