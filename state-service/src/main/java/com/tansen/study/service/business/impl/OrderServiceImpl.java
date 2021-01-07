/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.tansen.study.service.business.impl;

import com.tansen.study.domain.sale.OrderSaleDomain;
import com.tansen.study.dto.enums.SaleOrderStatusEnum;
import com.tansen.study.dto.exception.BusinessException;
import com.tansen.study.service.business.OrderService;
import com.tansen.study.service.event.SaleOrderEventEnum;
import com.tansen.study.service.event.driver.sale.SaleOrderEventDriver;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 功能说明
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/7
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 状态机的要素
     * 状态机可归纳为4个要素,即现态、事件、动作、次态。详解如下：
     * ①现态:是指当前对象所处的状态。
     * ②事件:也可称为"条件"。当一个条件被满足，将会触发一个动作，或者执行一次状态的迁移。
     * ③动作:条件满足后执行的动作，动作执行完毕后，可以迁移到新的状态，也可以仍旧保持原状态。动作不是必需的，当条件满足后，也可以不执行任何动作，直接迁移到目标状态。
     * ④次态:条件满足后要迁往的目标状态。“次态”是相对于“现态”而言的，“次态”一旦被激活，对象就转变成新的“现态”了。
     *
     *
     *
     * 状态机就是将驱动类，根据当前状态得到对应的执行者，执行者再根据指定事件，做对应动作，将当前状态改变为目标状态
     * 驱动类可以用同一个对象，也可以根据不同的事件操作使用不同的对象，例如订单审核没有其他个性化参数，就可以直接用公共的驱动者。
     *      再比如支付回调，将未支付改为待审核，就有支付时间这样个性化的参数，就可以用SaleOrderPayEventDriver驱动
     */

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
    @Override
    public String audit(String orderNo) {
        //查询订单
        OrderSaleDomain saleDomain = new OrderSaleDomain();
        saleDomain.setOrderStatus(SaleOrderStatusEnum.WAITING_AUDIT.getCode());
        //判断状态
        if (!Objects.equals(saleDomain.getOrderStatus(), SaleOrderStatusEnum.WAITING_AUDIT.getCode())) {
            throw new BusinessException("当前订单状态无法审核");
        }
        //状态机扭转
        SaleOrderEventDriver saleOrderEventDriver = new SaleOrderEventDriver();
        saleOrderEventDriver.setDomain(saleDomain);
        saleOrderEventDriver.setOperator("传入的操作人");
        //驱动者-->设置当前订单状态-->得到行动队长-->执行期望动作
        saleOrderEventDriver.status(SaleOrderStatusEnum.WAITING_AUDIT.getCode()).handle(SaleOrderEventEnum.AUDIT_TO_DELIVER);
        return "OK";
    }
}
