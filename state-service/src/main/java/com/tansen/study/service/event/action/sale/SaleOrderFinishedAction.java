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
 * 已完成
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/7/22
 */
@Service
public class SaleOrderFinishedAction extends AbstractSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(SaleOrderFinishedAction.class);

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

    }
}
