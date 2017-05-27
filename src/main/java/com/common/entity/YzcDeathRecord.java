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
 * 死亡记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_death_record")
public class YzcDeathRecord extends Model<YzcDeathRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer dea_id;
    /**
     * 耳号
     */
	private Integer dea_ear;
    /**
     * 日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dea_time;
    /**
     * 死亡原因
     */
	private String dea_reason;
    /**
     * 处理人员id
     */
	private Integer dea_rec_peo;


	public Integer getDea_id() {
		return dea_id;
	}

	public void setDea_id(Integer dea_id) {
		this.dea_id = dea_id;
	}

	public Integer getDea_ear() {
		return dea_ear;
	}

	public void setDea_ear(Integer dea_ear) {
		this.dea_ear = dea_ear;
	}

	public Date getDea_time() {
		return dea_time;
	}

	public void setDea_time(Date dea_time) {
		this.dea_time = dea_time;
	}

	public String getDea_reason() {
		return dea_reason;
	}

	public void setDea_reason(String dea_reason) {
		this.dea_reason = dea_reason;
	}

	public Integer getDea_rec_peo() {
		return dea_rec_peo;
	}

	public void setDea_rec_peo(Integer dea_rec_peo) {
		this.dea_rec_peo = dea_rec_peo;
	}

	@Override
	protected Serializable pkVal() {
		return this.dea_id;
	}

}
