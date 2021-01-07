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

import java.util.Objects;

/**
 * 退款中状态
 * <p>
 *
 * @author ：tansen
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Service
public class AfterSaleOrderRefundingAction extends AbstractAfterSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderRefundingAction.class);


    /**
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     */
    @Override
    public void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        if (Objects.equals(event, AfterSaleEventEnum.REFUND_TO_FINISHED)) {
            //退款成功已完成
        } else {
            throw new BusinessException("当前状态无法执行该操作");
        }
    }
}
