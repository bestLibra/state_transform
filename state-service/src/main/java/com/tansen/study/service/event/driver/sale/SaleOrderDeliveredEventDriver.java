/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.sale;

import lombok.Data;

/**
 * 封单
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/9/3
 */
@Data
public class SaleOrderDeliveredEventDriver extends AbstractSaleOrderDriver {
    /**
     * 物流商编码
     */
    private String logisticsCode;

    /**
     * 物流商名称
     */
    private String logisticsName;

    /**
     * 物流单号
     */
    private String expressNo;
}
