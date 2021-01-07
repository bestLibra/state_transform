/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.sale;

import lombok.Data;

import java.util.Date;

/**
 * 封单
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/9/3
 */
@Data
public class SaleOrderFinishEventDriver extends AbstractSaleOrderDriver {

    /**
     * 完成时间
     */
    private Date finishTime;
}
