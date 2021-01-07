/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event;

import com.tansen.study.dto.enums.AfterSaleStatusEnum;

/**
 * 售后单事件类型
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
public enum AfterSaleEventEnum {
    CREATE(10, "申请售后", AfterSaleStatusEnum.WAITING_AUDIT.getCode()),

    //审核通过待寄回
    AUDIT_TO_SEND_BACK(20, "审核通过", AfterSaleStatusEnum.WAITING_SEND_BACK.getCode()),

    //回传运单待入库
    SEND_BACK_TO_STORAGE(30, "买家已寄回", AfterSaleStatusEnum.WAITING_STORAGE.getCode()),

    //确认入库退款中，也可以增加节点，变成待退款，增加审核操作
    STORAGE_TO_REFUNDING(40, "退款中", AfterSaleStatusEnum.REFUNDING.getCode()),

    //取消销售单-审核通过直接退款-变成退款中
    AUDIT_TO_REFUNDING(41, "退款中", AfterSaleStatusEnum.REFUNDING.getCode()),

    //退款成功已完成
    REFUND_TO_FINISHED(70, "退款完成", AfterSaleStatusEnum.FINISHED.getCode()),

    REJECT_AUDIT(90, "审核不通过", AfterSaleStatusEnum.REJECT_AUDIT.getCode()),

    REJECT_STORAGE(100, "商家拒收", AfterSaleStatusEnum.REJECT_STORAGE.getCode()),

    //待审核时拒绝退货单
    WAITING_AUDIT_CANCEL(110, "取消售后", AfterSaleStatusEnum.CANCELED.getCode()),

    //待寄回取消退货单
    WAITING_SEND_BACK_CANCEL(120, "取消售后", AfterSaleStatusEnum.CANCELED.getCode()),

    //客户取消订单
    WAITING_AUDIT_CUSTOMER__CANCEL(130, "取消售后", AfterSaleStatusEnum.CANCELED.getCode());

    /**
     * 事件编码
     */
    private int code;

    /**
     * 事件描述
     */
    private String desc;

    /**
     * 目标状态
     */
    private Integer targetStatus;


    AfterSaleEventEnum(int code, String desc, Integer targetStatus) {
        this.code = code;
        this.desc = desc;
        this.targetStatus = targetStatus;
    }

    /**
     * Get by code.
     * <p>
     *
     * @author tansen.
     * @date 2019/8/6
     */
    public static AfterSaleEventEnum getByCode(int code) {
        for (AfterSaleEventEnum eventEnum : values()) {
            if (code == eventEnum.code) {
                return eventEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getTargetStatus() {
        return targetStatus;
    }

}
