/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.event.driver.sale;

import lombok.Data;

import java.util.Date;

/**
 * 取消销售单请求
 * <p>
 *
 * @author ：tansen.
 * @version : 1.0.0
 * @date ：2019/8/23
 */
@Data
public class SaleOrderPayEventDriver extends AbstractSaleOrderDriver {

    private Date payTime;
}
