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
public class AfterSaleOrderEventDriver extends AbstractAfterSaleOrderDriver implements Serializable {
    /**
     * 客服反馈 取消退货、拒绝收货原因
     */
    private String serviceFeedback;

}
