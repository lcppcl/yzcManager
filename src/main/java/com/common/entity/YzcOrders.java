package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * <p>
 * 订单记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_orders")
public class YzcOrders extends Model<YzcOrders> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.UUID)
	private String uuid;
    /**
     * 订单日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date order_date;
    /**
     * 总计
     */
	private BigDecimal order_sub;
    /**
     * 合作商id
     */
	private Integer order_sup;
    /**
     * 采购人员id
     */
	private Integer order_emp;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public BigDecimal getOrder_sub() {
		return order_sub;
	}

	public void setOrder_sub(BigDecimal order_sub) {
		this.order_sub = order_sub;
	}

	public Integer getOrder_sup() {
		return order_sup;
	}

	public void setOrder_sup(Integer order_sup) {
		this.order_sup = order_sup;
	}

	public Integer getOrder_emp() {
		return order_emp;
	}

	public void setOrder_emp(Integer order_emp) {
		this.order_emp = order_emp;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}
}
