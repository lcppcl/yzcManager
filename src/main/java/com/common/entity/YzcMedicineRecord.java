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
 * 用药记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_medicine_record")
public class YzcMedicineRecord extends Model<YzcMedicineRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer med_rec_id;
    /**
     * 用药时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date med_rec_time;
    /**
     * 药品量
     */
	private String med_rec_count;
    /**
     * 药品编号
     */
	private Integer med_rec_mec_id;
    /**
     * 喂养记录编号
     */
	private Integer med_rec_fee_id;
    /**
     * 病例表号
     */
	private Integer med_rec_ill_id;
    /**
     * 花费
     */
	private BigDecimal med_rec_money;


	public Integer getMed_rec_id() {
		return med_rec_id;
	}

	public void setMed_rec_id(Integer med_rec_id) {
		this.med_rec_id = med_rec_id;
	}

	public Date getMed_rec_time() {
		return med_rec_time;
	}

	public void setMed_rec_time(Date med_rec_time) {
		this.med_rec_time = med_rec_time;
	}

	public String getMed_rec_count() {
		return med_rec_count;
	}

	public void setMed_rec_count(String med_rec_count) {
		this.med_rec_count = med_rec_count;
	}

	public Integer getMed_rec_mec_id() {
		return med_rec_mec_id;
	}

	public void setMed_rec_mec_id(Integer med_rec_mec_id) {
		this.med_rec_mec_id = med_rec_mec_id;
	}

	public Integer getMed_rec_fee_id() {
		return med_rec_fee_id;
	}

	public void setMed_rec_fee_id(Integer med_rec_fee_id) {
		this.med_rec_fee_id = med_rec_fee_id;
	}

	public Integer getMed_rec_ill_id() {
		return med_rec_ill_id;
	}

	public void setMed_rec_ill_id(Integer med_rec_ill_id) {
		this.med_rec_ill_id = med_rec_ill_id;
	}

	public BigDecimal getMed_rec_money() {
		return med_rec_money;
	}

	public void setMed_rec_money(BigDecimal med_rec_money) {
		this.med_rec_money = med_rec_money;
	}

	@Override
	protected Serializable pkVal() {
		return this.med_rec_id;
	}

}
