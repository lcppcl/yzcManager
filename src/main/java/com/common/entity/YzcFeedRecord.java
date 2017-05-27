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
 * 喂养记录
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_feed_record")
public class YzcFeedRecord extends Model<YzcFeedRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fee_time;
    /**
     * 栏号
     */
	private Integer fee_class;
    /**
     * 饲料量
     */
	private String fee_count;
    /**
     * 饲料编号
     */
	private Integer fee_fes_id;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFee_time() {
		return fee_time;
	}

	public void setFee_time(Date fee_time) {
		this.fee_time = fee_time;
	}

	public Integer getFee_class() {
		return fee_class;
	}

	public void setFee_class(Integer fee_class) {
		this.fee_class = fee_class;
	}

	public String getFee_count() {
		return fee_count;
	}

	public void setFee_count(String fee_count) {
		this.fee_count = fee_count;
	}

	public Integer getFee_fes_id() {
		return fee_fes_id;
	}

	public void setFee_fes_id(Integer fee_fes_id) {
		this.fee_fes_id = fee_fes_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
