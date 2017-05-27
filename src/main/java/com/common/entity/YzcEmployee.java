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
 * 员工人员表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_employee")
public class YzcEmployee extends Model<YzcEmployee> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer emp_id;
    /**
     * 账号
     */
	private String emp_account;
    /**
     * 密码
     */
	private String emp_pwd;
    /**
     * 名称
     */
	private String emp_name;
    /**
     * 性别
     */
	private String emp_sex;
    /**
     * 生日
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emp_birth;
    /**
     * 电话
     */
	private String emp_phone;
    /**
     * 邮箱
     */
	private String emp_email;
    /**
     * 入职日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emp_in_date;
    /**
     * 描述
     */
	private String emp_desc;
    /**
     * 部门id
     */
	private Integer emp_dept_id;
	private Integer emp_manager;
    /**
     * 状态（0，1）
     */
	private Integer emp_state;


	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_account() {
		return emp_account;
	}

	public void setEmp_account(String emp_account) {
		this.emp_account = emp_account;
	}

	public String getEmp_pwd() {
		return emp_pwd;
	}

	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_sex() {
		return emp_sex;
	}

	public void setEmp_sex(String emp_sex) {
		this.emp_sex = emp_sex;
	}

	public Date getEmp_birth() {
		return emp_birth;
	}

	public void setEmp_birth(Date emp_birth) {
		this.emp_birth = emp_birth;
	}

	public String getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getEmp_in_date() {
		return emp_in_date;
	}

	public void setEmp_in_date(Date emp_in_date) {
		this.emp_in_date = emp_in_date;
	}

	public String getEmp_desc() {
		return emp_desc;
	}

	public void setEmp_desc(String emp_desc) {
		this.emp_desc = emp_desc;
	}

	public Integer getEmp_dept_id() {
		return emp_dept_id;
	}

	public void setEmp_dept_id(Integer emp_dept_id) {
		this.emp_dept_id = emp_dept_id;
	}

	public Integer getEmp_manager() {
		return emp_manager;
	}

	public void setEmp_manager(Integer emp_manager) {
		this.emp_manager = emp_manager;
	}

	public Integer getEmp_state() {
		return emp_state;
	}

	public void setEmp_state(Integer emp_state) {
		this.emp_state = emp_state;
	}

	@Override
	protected Serializable pkVal() {
		return this.emp_id;
	}

}
