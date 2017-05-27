package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * <p>
 * 猪买卖记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_deal_pig")
public class YzcDealPig extends Model<YzcDealPig> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer deal_id;
    /**
     * 日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deal_time;
    /**
     * 单价
     */
	private String deal_price;
    /**
     * 重量
     */
	private Double deal_weight;
    /**
     * 耳号
     */
	private Integer deal_ear;
    /**
     * 订单号
     */
	private String order_uuid;
    /**
     * （购入，卖出）
     */
	private String deal_buy_sell;


	public Integer getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Integer deal_id) {
		this.deal_id = deal_id;
	}

	public Date getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(Date deal_time) {
		this.deal_time = deal_time;
	}

	public String getDeal_price() {
		return deal_price;
	}

	public void setDeal_price(String deal_price) {
		this.deal_price = deal_price;
	}

	public Double getDeal_weight() {
		return deal_weight;
	}

	public void setDeal_weight(Double deal_weight) {
		this.deal_weight = deal_weight;
	}

	public Integer getDeal_ear() {
		return deal_ear;
	}

	public void setDeal_ear(Integer deal_ear) {
		this.deal_ear = deal_ear;
	}

	public String getOrder_uuid() {
		return order_uuid;
	}

	public void setOrder_uuid(String order_uuid) {
		this.order_uuid = order_uuid;
	}

	public String getDeal_buy_sell() {
		return deal_buy_sell;
	}

	public void setDeal_buy_sell(String deal_buy_sell) {
		this.deal_buy_sell = deal_buy_sell;
	}

	@Override
	protected Serializable pkVal() {
		return this.deal_id;
	}

}
