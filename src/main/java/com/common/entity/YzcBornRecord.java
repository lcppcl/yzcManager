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
 * 出生记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_born_record")
public class YzcBornRecord extends Model<YzcBornRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 出生日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bor_time;
    /**
     * 产量
     */
	private Integer bor_count;
    /**
     * 存活量
     */
	private Integer bor_live_count;
    /**
     * 怀孕编号
     */
	private Integer bor_pre_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBor_time() {
		return bor_time;
	}

	public void setBor_time(Date bor_time) {
		this.bor_time = bor_time;
	}

	public Integer getBor_count() {
		return bor_count;
	}

	public void setBor_count(Integer bor_count) {
		this.bor_count = bor_count;
	}

	public Integer getBor_live_count() {
		return bor_live_count;
	}

	public void setBor_live_count(Integer bor_live_count) {
		this.bor_live_count = bor_live_count;
	}

	public Integer getBor_pre_id() {
		return bor_pre_id;
	}

	public void setBor_pre_id(Integer bor_pre_id) {
		this.bor_pre_id = bor_pre_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
