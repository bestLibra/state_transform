/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.action.sale;

import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.SaleOrderEventEnum;
import com.tansen.study.service.event.driver.sale.AbstractSaleOrderDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单状态
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/7/20
 */
public abstract class AbstractSaleOrderAction {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSaleOrderAction.class);

    /**
     * 扭转动作
     * <p>
     *
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     * @author tansen.
     * @date 2019/7/22
     */
    public void action(AbstractSaleOrderDriver order, SaleOrderEventEnum event) throws BusinessException {
        handle(order, event);
        if (order.isPostHandle()) {
            postHandle(order, event);
        }
        // 与其他系统数据同步 异步处理
    }

    /**
     * 处理事件
     * <p>
     *
     * @param order 订单
     * @param event 事件类型
     * @throws BusinessException
     * @author tansen.
     * @date 2019/7/22
     */
    protected abstract void handle(AbstractSaleOrderDriver order, SaleOrderEventEnum event) throws BusinessException;

    /**
     * 状态扭转之后的公共后置处理
     */
    private void postHandle(AbstractSaleOrderDriver order, SaleOrderEventEnum eventEnum) throws BusinessException {
        //后置操作，可以是公共的操作，例如比如给所有操作流程节点
    }


}
