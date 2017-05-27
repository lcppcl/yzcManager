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
 * 配种记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_breed_record")
public class YzcBreedRecord extends Model<YzcBreedRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer bre_id;
    /**
     * 配种时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bre_time;
    /**
     * 配种母耳号
     */
	private Integer bre_mo_ear;
    /**
     * 配种父耳号
     */
	private Integer bre_fa_ear;


	public Integer getBre_id() {
		return bre_id;
	}

	public void setBre_id(Integer bre_id) {
		this.bre_id = bre_id;
	}

	public Date getBre_time() {
		return bre_time;
	}

	public void setBre_time(Date bre_time) {
		this.bre_time = bre_time;
	}

	public Integer getBre_mo_ear() {
		return bre_mo_ear;
	}

	public void setBre_mo_ear(Integer bre_mo_ear) {
		this.bre_mo_ear = bre_mo_ear;
	}

	public Integer getBre_fa_ear() {
		return bre_fa_ear;
	}

	public void setBre_fa_ear(Integer bre_fa_ear) {
		this.bre_fa_ear = bre_fa_ear;
	}

	@Override
	protected Serializable pkVal() {
		return this.bre_id;
	}

}
