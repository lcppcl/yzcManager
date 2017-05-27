package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 采购详情记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_purchase_record")
public class YzcPurchaseRecord extends Model<YzcPurchaseRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer pur_id;
    /**
     * 采购物品
     */
	private String pur_name;
    /**
     * 单价
     */
	private BigDecimal pur_price;
    /**
     * 采购数
     */
	private BigDecimal pur_count;
    /**
     * 单位
     */
	private String pur_unit;
    /**
     * 总计
     */
	private BigDecimal pur_total;
    /**
     * 订单号
     */
	private String order_uuid;


	public Integer getPur_id() {
		return pur_id;
	}

	public void setPur_id(Integer pur_id) {
		this.pur_id = pur_id;
	}

	public String getPur_name() {
		return pur_name;
	}

	public void setPur_name(String pur_name) {
		this.pur_name = pur_name;
	}

	public BigDecimal getPur_price() {
		return pur_price;
	}

	public void setPur_price(BigDecimal pur_price) {
		this.pur_price = pur_price;
	}

	public BigDecimal getPur_count() {
		return pur_count;
	}

	public void setPur_count(BigDecimal pur_count) {
		this.pur_count = pur_count;
	}

	public String getPur_unit() {
		return pur_unit;
	}

	public void setPur_unit(String pur_unit) {
		this.pur_unit = pur_unit;
	}

	public BigDecimal getPur_total() {
		return pur_total;
	}

	public void setPur_total(BigDecimal pur_total) {
		this.pur_total = pur_total;
	}

	@Override
	protected Serializable pkVal() {
		return this.pur_id;
	}

	public String getOrder_uuid() {
		return order_uuid;
	}

	public void setOrder_uuid(String order_uuid) {
		this.order_uuid = order_uuid;
	}
}
