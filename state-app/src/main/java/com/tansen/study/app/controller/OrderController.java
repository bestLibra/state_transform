package com.tansen.study.app.controller;/*
 * 深圳市灵智数科有限公司版权所有.
 */


import com.tansen.study.service.business.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单操作
 * <p>
 *
 * @author 谭森
 * @version 1.0.0
 * @date 2021/1/7
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

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
    @RequestMapping(value = "/audit", method = RequestMethod.GET)
    public String confirm(String orderNo) {
        return orderService.audit(orderNo);
    }

}
