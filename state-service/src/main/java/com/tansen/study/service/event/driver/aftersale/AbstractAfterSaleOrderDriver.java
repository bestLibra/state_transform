/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.aftersale;

import com.tansen.study.domain.aftersale.AfterSaleOrderDomain;
import com.tansen.study.dto.enums.AfterSaleStatusEnum;
import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.AfterSaleEventEnum;
import com.tansen.study.service.event.action.aftersale.AbstractAfterSaleOrderAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderFinishedAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderRefundingAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderWaitingAuditAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderWaitingRefundAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderWaitingSendBackAction;
import com.tansen.study.service.event.action.aftersale.AfterSaleOrderWaitingStorageAction;
import com.tansen.study.service.utils.SpringBeanContextUtil;
import lombok.Data;

/**
 * 售后订单操作
 * <p>
 *
 * @author ：tansen
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Data
public abstract class AbstractAfterSaleOrderDriver {

    /**
     * 售后单
     */
    private AfterSaleOrderDomain domain;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作来源
     */
    private Integer operateSource;

    /**
     * 当前订单状态
     */
    private AbstractAfterSaleOrderAction currentStatus;


    /**
     * 是否需要后置处理, true 需要, false 不需要
     */
    private boolean postHandle = true;

    /**
     * 下一个事件
     */
    private AfterSaleEventEnum nextEvent;

    /**
     * 处理事件
     * <p>
     *
     * @param event 事件类型
     * @author tansen.
     * @date 2019/7/22
     */
    public void handle(AfterSaleEventEnum event) throws BusinessException {
        getCurrentStatus().action(this, event);
    }

    /**
     * 设置状态
     *
     * @param orderStatus 订单状态
     * @return AbstractOrder this
     * @author tansen.
     * @date 2019/8/23
     */
    public AbstractAfterSaleOrderDriver status(Integer orderStatus) throws BusinessException {
        AfterSaleStatusEnum status = AfterSaleStatusEnum.getByCode(orderStatus);
        if (status == null) {
            throw new BusinessException("当前状态无法执行该操作");
        }

        switch (status) {
            case WAITING_AUDIT:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderWaitingAuditAction.class);
                break;
            case WAITING_SEND_BACK:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderWaitingSendBackAction.class);
                break;
            case WAITING_STORAGE:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderWaitingStorageAction.class);
                break;
            case WAITING_REFUND:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderWaitingRefundAction.class);
                break;
            case REFUNDING:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderRefundingAction.class);
                break;
            case FINISHED:
                currentStatus = SpringBeanContextUtil.getBean(AfterSaleOrderFinishedAction.class);
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
        return this;
    }
}
