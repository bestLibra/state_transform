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
 * 待入库状态
 * <p>
 *
 * @author ：tansen
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Service
public class AfterSaleOrderWaitingStorageAction extends AbstractAfterSaleOrderAction {
    private static final Logger logger = LoggerFactory.getLogger(AfterSaleOrderWaitingStorageAction.class);

    /**
     * @param order 订单
     * @param event 事件类型
     * @throws com.tansen.study.dto.exception.BusinessException
     */
    @Override
    public void handle(AbstractAfterSaleOrderDriver order, AfterSaleEventEnum event) throws BusinessException {
        // 入库退款( 待入库 -> 确认入库 -> 退款中 )
        if (Objects.equals(event, AfterSaleEventEnum.STORAGE_TO_REFUNDING)) {
            //处理退款、退扣除赠送积分、退运费
        } else if (Objects.equals(event, AfterSaleEventEnum.REJECT_STORAGE)) {
            //取消订单(拒绝收货)
        } else {
            throw new BusinessException("当前状态无法执行该操作");
        }

    }


}
