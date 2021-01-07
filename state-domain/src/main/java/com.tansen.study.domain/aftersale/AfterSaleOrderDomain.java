/*
 * 深圳市灵智数科有限公司版权所有..
 */
package com.tansen.study.domain.aftersale;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 售后单实体
 * <p>
 *
 * @author tansen
 * @version 1.0.0
 * @date 2021/1/6
 */
@Data
@ToString
public class AfterSaleOrderDomain {
    /**
     * 主键
     */
    private Long id;
    /**
     * 租户ID
     */
    private Long tenantId;
    /**
     * 商城ID
     */
    private Long storeId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 原正向单号
     */
    private String saleOrderNo;

    /**
     * 订单类别 1=仅退款，2=退货退款，3=取消销售单，4=补差单
     */
    private Integer orderType;

    /**
     * 售后渠道 1=APP，2=中台
     */
    private Integer afterSaleChannel;

    /**
     * 订单状态
     */
    private Integer orderStatus;

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
     * 会员卡等级
     */
    private Integer customerCardLevel;
    /**
     * 会员卡等级名称
     */
    private String customerCardLevelName;

    /**
     * 会员手机号
     */
    private String customerPhone;

    /**
     * 会员姓名
     */
    private String customerName;

    /**
     * 是否最后一次退(0=否 ，1=是)
     */
    private Integer lastReturn;

    /**
     * 退货方式 1=客户寄回，2=上门取货, 3=到店退货，4=商品无需取回
     */
    private Integer returnWay;

    /**
     * 退款方式 1=原路退回，2=退银行卡
     */
    private Integer refundWay;

    /**
     * 商品总价
     */
    private BigDecimal totalProductPrice;

    /**
     * 促销活动折扣
     */
    private BigDecimal totalPromoDiscount;

    /**
     * 会员折扣
     */
    private BigDecimal totalCustomerDiscount;

    /**
     * 促销券折扣
     */
    private BigDecimal totalCouponDiscount;

    /**
     * 应退订单金额 = 商品总价-总折扣+运费
     */
    private BigDecimal totalAmount;

    /**
     * 退货地址类型 退货地址类型：1、退货各自门店 2、退回总仓
     */
    private Integer returnAddrType;

    /**
     * 退运费
     */
    private BigDecimal freight;

    /**
     * 运费优惠
     */
    private BigDecimal freightDiscount;


    /**
     * 券支付金额
     */
    private BigDecimal totalCouponAmount;

    /**
     * 积分抵扣金额
     */
    private BigDecimal totalPointAmount;

    /**
     * 实际退款金额
     */
    private BigDecimal totalRefundAmount;

    /**
     * 使用积分
     */
    private BigDecimal totalReturnPoint;

    /**
     * 扣除赠送积分 =sum(give_point)
     */
    private BigDecimal totalDeductPoint;

    /**
     * 扣除赠送成长值
     */
    private BigDecimal totalDeductGrowth;

    /**
     * 退款流程？？？ 0=正常退款，1=极速退
     */
    private Integer refundProcess;

    /**
     * 售后原因 编码
     */
    private String reasonCode;

    /**
     * 问题描述
     */
    private String descInfo;

    /**
     * 客服备注
     */
    private String serviceRemark;

    /**
     * 客服反馈(审核取消时的原因)
     */
    private String serviceFeedback;
    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 退款时间
     */
    private Date refundTime;

    /**
     * 完成时间
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
     * 版本号
     */
    private Integer version;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

}

