/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.business;

/**
 * 功能说明
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/7
 */
public interface OrderService {
    /**
     * 审核订单
     * <p>
     *
     * @param orderNo
     * @return
     * @author tansen
     * @date 2021/1/7
     * @version 1.0.0
     */
    String audit(String orderNo);

}
