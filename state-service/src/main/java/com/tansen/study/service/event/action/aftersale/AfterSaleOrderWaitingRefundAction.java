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
 * 待退款状态
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2020/2/19
 */
@Service
public class AfterSaleOrderWaitingRefundAction extends AbstractAfterSaleOrderAction {

    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderWaitingRefundAction.class);


    /**
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     */
    @Override
    public void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        //现在没有待退款状态，确认入库，直接退款
    }

}
