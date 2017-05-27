package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 生长阶段
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_step")
public class YzcStep extends Model<YzcStep> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 阶段名称
     */
	private String step_name;
    /**
     * 日期
     */
	private String step_period;
    /**
     * 描述
     */
	private String step_desc;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStep_name() {
		return step_name;
	}

	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}

	public String getStep_period() {
		return step_period;
	}

	public void setStep_period(String step_period) {
		this.step_period = step_period;
	}

	public String getStep_desc() {
		return step_desc;
	}

	public void setStep_desc(String step_desc) {
		this.step_desc = step_desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
