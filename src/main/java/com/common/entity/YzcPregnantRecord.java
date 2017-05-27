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
 * 怀孕记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_pregnant_record")
public class YzcPregnantRecord extends Model<YzcPregnantRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer pre_id;
    /**
     * 怀孕日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pre_found_pre;
    /**
     * 配种表id
     */
	private Integer pre_bre_id;


	public Integer getPre_id() {
		return pre_id;
	}

	public void setPre_id(Integer pre_id) {
		this.pre_id = pre_id;
	}

	public Date getPre_found_pre() {
		return pre_found_pre;
	}

	public void setPre_found_pre(Date pre_found_pre) {
		this.pre_found_pre = pre_found_pre;
	}

	public Integer getPre_bre_id() {
		return pre_bre_id;
	}

	public void setPre_bre_id(Integer pre_bre_id) {
		this.pre_bre_id = pre_bre_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.pre_id;
	}

}
