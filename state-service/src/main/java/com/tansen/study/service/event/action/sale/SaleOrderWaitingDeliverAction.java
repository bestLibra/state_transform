/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.action.sale;

import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.SaleOrderEventEnum;
import com.tansen.study.service.event.driver.sale.AbstractSaleOrderDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 待发货状态
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/7/21
 */
@Service
public class SaleOrderWaitingDeliverAction extends AbstractSaleOrderAction {
    public final Logger logger = LoggerFactory.getLogger(getClass());

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
    @Override
    public void handle(AbstractSaleOrderDriver order, SaleOrderEventEnum event) throws BusinessException {
        switch (event) {
            case DELIVER_THEN_RECEIPT:
                // 确认发货后待收货
                break;
            case RECEIPT:
                // 封单
                break;
            case CANCEL_BEFORE_DELIVER:
                // 取消订单
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
    }
}
