/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.action.aftersale;


import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.AfterSaleEventEnum;
import com.tansen.study.service.event.driver.aftersale.AbstractAfterSaleOrderDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 售后订单状态
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2020/2/19
 */
public abstract class AbstractAfterSaleOrderAction {

    private static final Logger logger = LoggerFactory.getLogger(AbstractAfterSaleOrderAction.class);

    /**
     * 扭转动作
     * <p>
     *
     * @param event 事件类型
     * @author tansen.
     * @date 2019/7/22
     */
    //这里可以对事务统一控制
//    @Transactional(rollbackFor = Exception.class)
    public void action(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        handle(order, event);
        // 后置处理操作
        if (order.isPostHandle()) {
            postHandle(order, event);
        }
    }

    /**
     * 处理事件
     * <p>
     *
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     * @author tansen.
     * @date 2019/7/22
     */
    protected abstract void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException;

    /**
     * 后置处理操作
     *
     * @param order
     * @param eventEnum
     */
    private void postHandle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum eventEnum) throws BusinessException {
    }
}
