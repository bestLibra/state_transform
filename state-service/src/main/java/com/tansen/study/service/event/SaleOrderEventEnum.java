/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event;

import com.tansen.study.dto.enums.SaleOrderStatusEnum;

/**
 * 销售单事件类型
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
public enum SaleOrderEventEnum {

    /**
     * 下单后待支付
     */
    CREATE(10, "创建订单，待支付", SaleOrderStatusEnum.WAITING_PAY.getCode()),

    /**
     * 支付完成待审核
     */
    PAY_TO_AUDIT(20, "买家付款，待审核", SaleOrderStatusEnum.WAITING_AUDIT.getCode()),

    /**
     * 审核通过待发货
     */
    AUDIT_TO_DELIVER(30, "审核通过，待发货", SaleOrderStatusEnum.WAITING_DELIVERY.getCode()),

    /**
     * 发货后待收货
     */
    DELIVER_THEN_RECEIPT(40, "已发货，待收货", SaleOrderStatusEnum.DELIVERED.getCode()),

    /**
     * 签收
     */
    RECEIPT(50, "确认收货，已完成", SaleOrderStatusEnum.FINISHED.getCode()),

    /**
     * 未支付取消
     */
    CANCEL_BEFORE_PAY(60, "未支付取消订单", SaleOrderStatusEnum.CANCELED_BEFORE_PAY.getCode()),

    /**
     * 已支付取消
     */
    CANCEL_AFTER_PAY(61, "已支付取消订单", SaleOrderStatusEnum.CANCELED_AFTER_PAY.getCode()),

    /**
     * 审核取消
     */
    CANCEL_WHEN_AUDIT(62, "审核不通过", SaleOrderStatusEnum.AUDIT_FAIL.getCode()),

    /**
     * 未出库取消
     */
    CANCEL_BEFORE_DELIVER(63, "未发货取消订单", SaleOrderStatusEnum.CANCELED_BEFORE_DELIVERY.getCode());


    private int code;

    private String name;

    private Integer targetStatus;

    SaleOrderEventEnum(int code, String name, Integer targetStatus) {
        this.code = code;
        this.name = name;
        this.targetStatus = targetStatus;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getTargetStatus() {
        return targetStatus;
    }

    /**
     * 通过code获取事件
     *
     * @param code
     * @return
     */
    public static SaleOrderEventEnum getByCode(int code) {
        for (SaleOrderEventEnum eventEnum : values()) {
            if (code == eventEnum.code) {
                return eventEnum;
            }
        }
        return null;
    }
}
