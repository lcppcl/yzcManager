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
 * 病历表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_ill_record")
public class YzcIllRecord extends Model<YzcIllRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer ill_id;
    /**
     * 疾病名称
     */
	private String ill_name;
    /**
     * 生病猪耳号
     */
	private Integer ill_ear;
    /**
     * 生病时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ill_time;
    /**
     * 药方
     */
	private String ill_med_list;
    /**
     * 开药人员id
     */
	private Integer ill_doctor;
    /**
     * 备注
     */
	private String ill_desc;


	public Integer getIll_id() {
		return ill_id;
	}

	public void setIll_id(Integer ill_id) {
		this.ill_id = ill_id;
	}

	public String getIll_name() {
		return ill_name;
	}

	public void setIll_name(String ill_name) {
		this.ill_name = ill_name;
	}

	public Integer getIll_ear() {
		return ill_ear;
	}

	public void setIll_ear(Integer ill_ear) {
		this.ill_ear = ill_ear;
	}

	public Date getIll_time() {
		return ill_time;
	}

	public void setIll_time(Date ill_time) {
		this.ill_time = ill_time;
	}

	public String getIll_med_list() {
		return ill_med_list;
	}

	public void setIll_med_list(String ill_med_list) {
		this.ill_med_list = ill_med_list;
	}

	public Integer getIll_doctor() {
		return ill_doctor;
	}

	public void setIll_doctor(Integer ill_doctor) {
		this.ill_doctor = ill_doctor;
	}

	public String getIll_desc() {
		return ill_desc;
	}

	public void setIll_desc(String ill_desc) {
		this.ill_desc = ill_desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.ill_id;
	}

}
