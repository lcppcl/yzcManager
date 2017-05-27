package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 品种表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_variety")
public class YzcVariety extends Model<YzcVariety> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer var_id;
    /**
     * 品种名称
     */
	private String var_name;
    /**
     * 品种描述
     */
	private String var_desc;


	public Integer getVar_id() {
		return var_id;
	}

	public void setVar_id(Integer var_id) {
		this.var_id = var_id;
	}

	public String getVar_name() {
		return var_name;
	}

	public void setVar_name(String var_name) {
		this.var_name = var_name;
	}

	public String getVar_desc() {
		return var_desc;
	}

	public void setVar_desc(String var_desc) {
		this.var_desc = var_desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.var_id;
	}

}
