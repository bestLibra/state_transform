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
 * 待寄回状态
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2020/2/19
 */
@Service
public class AfterSaleOrderWaitingSendBackAction extends AbstractAfterSaleOrderAction {

    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderWaitingSendBackAction.class);


    /**
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     */
    @Override
    public void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        if (Objects.equals(event, AfterSaleEventEnum.SEND_BACK_TO_STORAGE)) {
            //寄回商品
        } else if (Objects.equals(event, AfterSaleEventEnum.WAITING_SEND_BACK_CANCEL)) {
            //待寄回取消订单
        } else {
            throw new BusinessException("当前状态无法执行该操作");
        }

    }

}
