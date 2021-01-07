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
 * 待支付状态
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/7/20
 */
@Service
public class SaleOrderWaitingPayAction extends AbstractSaleOrderAction {

    private static final Logger logger = LoggerFactory.getLogger(SaleOrderWaitingPayAction.class);

    /**
     * 处理事件
     * <p>
     * <p>
     * order 订单
     *
     * @param event 事件类型
     * @author tansen.
     * @date 2019/7/22
     */
    @Override
    public void handle(AbstractSaleOrderDriver order, SaleOrderEventEnum event) throws BusinessException {
        switch (event) {
            case CANCEL_BEFORE_PAY:
                //do someting
                break;
            case PAY_TO_AUDIT:
                //do someting
                break;
            default:
                throw new BusinessException("当前状态无法执行该操作");
        }
    }
//
//    /**
//     * 判断是否需要自动审核
//     *
//     * @param order
//     */
//    private void autoAudit(AbstractSaleOrder order) throws BusinessException {
//        OrderSaleDomain saleDomain = order.getDomain();
//
//        try {
//            int oldOrderStatus = saleDomain.getOrderStatus();
//            saleDomain.setOrderStatus(SaleOrderEventEnum.PAY_TO_AUDIT.getTargetStatus());
//            //支付成功消息提醒
//            clientOrderMessageService.sendOrderPaySuccessRemind(saleDomain);
//
//            //读取销售订单配置(默认人工审核)
//            int auditType = 2;
//            OrderSaleConfigDomain orderSaleConfigDomain = new OrderSaleConfigDomain();
//            orderSaleConfigDomain.setStoreId(saleDomain.getStoreId());
//            orderSaleConfigDomain.setTenantId(saleDomain.getTenantId());
//            orderSaleConfigDomain = orderSaleConfigService.queryOrderSaleConfig(orderSaleConfigDomain);
//            logger.info("orderNo:{},自动审核查询结果===>{}", saleDomain.getOrderNo(), JSON.toJSONString(orderSaleConfigDomain));
//            if (orderSaleConfigDomain != null) {
//                auditType = orderSaleConfigDomain.getAuditType();
//            }
//            // 订单
//            order.setOperator(CommonDescEnum.CUSTOMER.getLanguageDesc());
//            if (auditType == 1) {
//                //自动审核
//                order.setOperator(CommonDescEnum.SYSTEM.getLanguageDesc());
//                order.setNextEvent(SaleOrderEventEnum.AUDIT_TO_DELIVER);
//                // 发货消息提醒
//                saleDomain.setOrderStatus(SaleOrderEventEnum.AUDIT_TO_DELIVER.getTargetStatus());
//                orderMessageService.deliveryRemind(saleDomain);
//            } else {
//                // 人工审核，未审核消息提醒
//                orderMessageService.waitAuditRemind(saleDomain);
//            }
//            //还原状态
//            saleDomain.setOrderStatus(oldOrderStatus);
//        } catch (BusinessException e) {
//            logger.error("orderNo:{},支付后自动审核处理异常", saleDomain.getOrderNo(), e);
//        }
//    }
}
