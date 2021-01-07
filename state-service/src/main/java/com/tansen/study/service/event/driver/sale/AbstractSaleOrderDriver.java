/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.sale;

import com.tansen.study.domain.sale.OrderSaleDomain;
import com.tansen.study.dto.enums.SaleOrderStatusEnum;
import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.SaleOrderEventEnum;
import com.tansen.study.service.event.action.sale.AbstractSaleOrderAction;
import com.tansen.study.service.event.action.sale.SaleOrderDeliveredAction;
import com.tansen.study.service.event.action.sale.SaleOrderFinishedAction;
import com.tansen.study.service.event.action.sale.SaleOrderWaitingAuditAction;
import com.tansen.study.service.event.action.sale.SaleOrderWaitingDeliverAction;
import com.tansen.study.service.event.action.sale.SaleOrderWaitingPayAction;
import com.tansen.study.service.utils.SpringBeanContextUtil;
import lombok.Data;

/**
 * 订单抽象类
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2020/2/19
 */
@Data
public abstract class AbstractSaleOrderDriver {

    /**
     * 销售单
     */
    private OrderSaleDomain domain;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 是否需要后置处理, true 需要, false 不需要
     */
    private boolean postHandle = true;

    /**
     * 当前订单状态
     */
    private AbstractSaleOrderAction currentStatus;


    /**
     * 下一个事件
     */
    private SaleOrderEventEnum nextEvent;

    /**
     * 处理事件
     * <p>
     *
     * @param event 事件类型
     * @author tansen.
     * @date 2019/7/22
     */
    public void handle(SaleOrderEventEnum event) throws BusinessException {
        getCurrentStatus().action(this, event);
    }

    /**
     * 设置状态
     *
     * @param orderStatus 订单状态
     * @return AbstractOrder this
     * @throws BusinessException
     * @author tansen
     * @date 2020-2-19
     */
    public AbstractSaleOrderDriver status(Integer orderStatus) throws BusinessException {
        SaleOrderStatusEnum status = SaleOrderStatusEnum.getByCode(orderStatus);
        if (status == null) {
            throw new BusinessException("当前状态无法执行该操作");
        }

        switch (status) {
            case WAITING_PAY:
                currentStatus = SpringBeanContextUtil.getBean(SaleOrderWaitingPayAction.class);
                break;
            case WAITING_AUDIT:
                currentStatus = SpringBeanContextUtil.getBean(SaleOrderWaitingAuditAction.class);
                break;
            case WAITING_DELIVERY:
                currentStatus = SpringBeanContextUtil.getBean(SaleOrderWaitingDeliverAction.class);
                break;
            case DELIVERED:
                currentStatus = SpringBeanContextUtil.getBean(SaleOrderDeliveredAction.class);
                break;
            case FINISHED:
                currentStatus = SpringBeanContextUtil.getBean(SaleOrderFinishedAction.class);
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
        return this;
    }

}
