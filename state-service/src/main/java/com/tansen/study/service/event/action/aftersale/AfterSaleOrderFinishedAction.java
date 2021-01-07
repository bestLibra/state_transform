/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.action.aftersale;

import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.event.AfterSaleEventEnum;
import com.tansen.study.service.event.driver.aftersale.AbstractAfterSaleOrderDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 售后单已完成状态
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/9/11
 */
@Service
public class AfterSaleOrderFinishedAction extends AbstractAfterSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderFinishedAction.class);

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
    protected void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        logger.info("{}#####售后单完成", order.getDomain().getOrderNo());
    }

}
