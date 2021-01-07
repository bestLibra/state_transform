/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.aftersale;

import lombok.Data;

import java.io.Serializable;

/**
 * 售后单请求事件
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/8/5
 */
@Data
public class AfterOrderSendBackEventDriver extends AbstractAfterSaleOrderDriver implements Serializable {

    /**
     * 物流商ID
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
