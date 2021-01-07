/*
 * 深圳市灵智数科有限公司版权所有..
 */
package com.tansen.study.domain.sale;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
@Data
@ToString
public class OrderSaleDomain {

    /**
     * 主键
     */
    private Long id;

    /**
     * 会员ID
     */
    private Long customerId;

    /**
     * 会员账号
     */
    private String customerAccount;

    /**
     * 会员卡号
     */
    private String customerCard;

    /**
     * 会员姓名
     */
    private String customerName;

    /**
     * 会员卡等级
     */
    private Integer customerCardLevel;

    /**
     * 会员卡等级
     */
    private String customerCardLevelName;

    /**
     * 会员权益折扣
     */
    private String customerEquityDiscount;

    /**
     * 会员手机号
     */
    private String customerPhone;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付状态 0=初始化，1=待支付，2=未支付取消，3=已支付，4=已支付取消
     */
    private Integer payStatus;

    /**
     * 物流状态
     */
    private Integer logisticsStatus;

    /**
     * 商品总价 = sum(sale_price * sale_qty)
     */
    private BigDecimal totalProductPrice;

    /**
     * 促销活动折扣
     */
    private BigDecimal totalPromoDiscount;

    /**
     * 促销券折扣
     */
    private BigDecimal totalCouponDiscount;

    /**
     * 会员折扣
     */
    private BigDecimal totalCustomerDiscount;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 运费优惠
     */
    private BigDecimal freightDiscount;

    /**
     * 订单金额 = 商品总价-促销折扣(不包含优惠券)+运费
     */
    private BigDecimal totalAmount;

    /**
     * 券支付金额(抵扣券)
     */
    private BigDecimal totalCouponAmount;

    /**
     * 积分支付金额
     */
    private BigDecimal totalPointAmount;

    /**
     * 使用积分
     */
    private BigDecimal totalUsePoint;

    /**
     * 实付款 = 订单金额-优惠券-积分抵扣-抵扣券
     */
    private BigDecimal realPayAmount;

    /**
     * 赠送总积分 = sum(give_point)
     */
    private BigDecimal totalGivePoint;

    /**
     * 赠送总成长值 = sum(give_growth)
     */
    private BigDecimal totalGiveGrowth;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 交易完成时间
     */
    private Date finishTime;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 是否删除 0=否，1=是
     */
    private Integer deleted;

    /**
     * 数据版本号
     */
    private Integer version;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

}

