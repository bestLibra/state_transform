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
 * 待审核状态
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/7/20
 */
@Service
public class SaleOrderWaitingAuditAction extends AbstractSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(SaleOrderWaitingAuditAction.class);


    /**
     * 处理事件
     * <p>
     *
     * @param order 订单
     * @param event 事件类型
     * @author tansen.
     * @date 2019/7/22
     */
    @Override
    public void handle(AbstractSaleOrderDriver order, SaleOrderEventEnum event) throws BusinessException {
        switch (event) {
            case AUDIT_TO_DELIVER:
                // 审核通过待发货
                logger.info("orderNo:{},订单审核待发货......", order.getDomain().getOrderNo());
                break;
            case CANCEL_WHEN_AUDIT:
                // 审核取消
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
    }
}
