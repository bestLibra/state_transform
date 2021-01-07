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
 * 待审核状态
 * <p>
 *
 * @author ：xiaox
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Service
public class AfterSaleOrderWaitingAuditAction extends AbstractAfterSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderWaitingAuditAction.class);

    /**
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     */
    @Override
    public void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        switch (event) {
            case REJECT_AUDIT:
                // 取消订单(顾客取消,审核取消)
                break;
            case AUDIT_TO_REFUNDING:
                // 取消销售单 审核通过-退款
                //处理退款、退扣除赠送积分、退运费
                break;
            case AUDIT_TO_SEND_BACK:
                // 买家寄回
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
    }
}
