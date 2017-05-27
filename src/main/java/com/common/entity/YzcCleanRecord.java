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
 * 打扫记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_clean_record")
public class YzcCleanRecord extends Model<YzcCleanRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer cle_id;
    /**
     * 时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cle_time;
    /**
     * 栏号id
     */
	private Integer cle_cla_id;
    /**
     * 打扫人员
     */
	private Integer cle_emp_id;
    /**
     * 备注
     */
	private String cle_desc;


	public Integer getCle_id() {
		return cle_id;
	}

	public void setCle_id(Integer cle_id) {
		this.cle_id = cle_id;
	}

	public Date getCle_time() {
		return cle_time;
	}

	public void setCle_time(Date cle_time) {
		this.cle_time = cle_time;
	}

	public Integer getCle_cla_id() {
		return cle_cla_id;
	}

	public void setCle_cla_id(Integer cle_cla_id) {
		this.cle_cla_id = cle_cla_id;
	}

	public Integer getCle_emp_id() {
		return cle_emp_id;
	}

	public void setCle_emp_id(Integer cle_emp_id) {
		this.cle_emp_id = cle_emp_id;
	}

	public String getCle_desc() {
		return cle_desc;
	}

	public void setCle_desc(String cle_desc) {
		this.cle_desc = cle_desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.cle_id;
	}

}
