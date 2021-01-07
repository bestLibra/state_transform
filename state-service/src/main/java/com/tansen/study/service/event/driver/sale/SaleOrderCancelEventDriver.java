/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.sale;

import lombok.Data;

/**
 * 取消销售单请求
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Data
public class SaleOrderCancelEventDriver extends AbstractSaleOrderDriver {

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 取消渠道
     */
    private Integer cancelChannel;
}
