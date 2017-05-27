package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 部门表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_department")
public class YzcDepartment extends Model<YzcDepartment> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer dept_id;
    /**
     * 部门名称
     */
	private String dept_name;
    /**
     * 描述
     */
	private String dept_desc;
    /**
     * 父id
     */
	private Integer dept_pare_id;
    /**
     * 状态
     */
	private Integer dept_state;


	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_desc() {
		return dept_desc;
	}

	public void setDept_desc(String dept_desc) {
		this.dept_desc = dept_desc;
	}

	public Integer getDept_pare_id() {
		return dept_pare_id;
	}

	public void setDept_pare_id(Integer dept_pare_id) {
		this.dept_pare_id = dept_pare_id;
	}

	public Integer getDept_state() {
		return dept_state;
	}

	public void setDept_state(Integer dept_state) {
		this.dept_state = dept_state;
	}

	@Override
	protected Serializable pkVal() {
		return this.dept_id;
	}

}
