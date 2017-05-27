package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 合作商
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_partner")
public class YzcPartner extends Model<YzcPartner> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer par_id;
    /**
     * 合作商名称
     */
	private String par_name;
    /**
     * 地址
     */
	private String par_address;
    /**
     * 手机号
     */
	private String par_phone;
    /**
     * 邮箱
     */
	private String par_email;
    /**
     * 种类
     */
	private String par_type;
    /**
     * 状态（0，1）
     */
	private Integer par_state;


	public Integer getPar_id() {
		return par_id;
	}

	public void setPar_id(Integer par_id) {
		this.par_id = par_id;
	}

	public String getPar_name() {
		return par_name;
	}

	public void setPar_name(String par_name) {
		this.par_name = par_name;
	}

	public String getPar_address() {
		return par_address;
	}

	public void setPar_address(String par_address) {
		this.par_address = par_address;
	}

	public String getPar_phone() {
		return par_phone;
	}

	public void setPar_phone(String par_phone) {
		this.par_phone = par_phone;
	}

	public String getPar_email() {
		return par_email;
	}

	public void setPar_email(String par_email) {
		this.par_email = par_email;
	}

	public String getPar_type() {
		return par_type;
	}

	public void setPar_type(String par_type) {
		this.par_type = par_type;
	}

	public Integer getPar_state() {
		return par_state;
	}

	public void setPar_state(Integer par_state) {
		this.par_state = par_state;
	}

	@Override
	protected Serializable pkVal() {
		return this.par_id;
	}

}
