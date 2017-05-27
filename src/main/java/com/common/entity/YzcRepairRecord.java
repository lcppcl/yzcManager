package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * <p>
 * 维修记录表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_repair_record")
public class YzcRepairRecord extends Model<YzcRepairRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer rep_id;
    /**
     * 栏号
     */
	private Integer rep_cla_id;
    /**
     * 描述
     */
	private String rep_desc;
    /**
     * 发现破损时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rep_found_tine;
    /**
     * 维修时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rep_time;
    /**
     * 维修结果
     */
	private String rep_result;
    /**
     * 维修人员id
     */
	private Integer rep_emp_id;
    /**
     * 花费金额
     */
	private BigDecimal rep_spend;


	public Integer getRep_id() {
		return rep_id;
	}

	public void setRep_id(Integer rep_id) {
		this.rep_id = rep_id;
	}

	public Integer getRep_cla_id() {
		return rep_cla_id;
	}

	public void setRep_cla_id(Integer rep_cla_id) {
		this.rep_cla_id = rep_cla_id;
	}

	public String getRep_desc() {
		return rep_desc;
	}

	public void setRep_desc(String rep_desc) {
		this.rep_desc = rep_desc;
	}

	public Date getRep_found_tine() {
		return rep_found_tine;
	}

	public void setRep_found_tine(Date rep_found_tine) {
		this.rep_found_tine = rep_found_tine;
	}

	public Date getRep_time() {
		return rep_time;
	}

	public void setRep_time(Date rep_time) {
		this.rep_time = rep_time;
	}

	public String getRep_result() {
		return rep_result;
	}

	public void setRep_result(String rep_result) {
		this.rep_result = rep_result;
	}

	public Integer getRep_emp_id() {
		return rep_emp_id;
	}

	public void setRep_emp_id(Integer rep_emp_id) {
		this.rep_emp_id = rep_emp_id;
	}

	public BigDecimal getRep_spend() {
		return rep_spend;
	}

	public void setRep_spend(BigDecimal rep_spend) {
		this.rep_spend = rep_spend;
	}

	@Override
	protected Serializable pkVal() {
		return this.rep_id;
	}

}
