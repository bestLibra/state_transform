/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.aftersale;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 售后单退款请求事件
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/8/5
 */
@Data
public class AfterSaleOrderRefundEventDriver extends AbstractAfterSaleOrderDriver implements Serializable {

    /**
     * 微信流水号
     */
    private String serialNo;

    /**
     * 退款完成时间
     */
    private Date refundFinishTime;

}
