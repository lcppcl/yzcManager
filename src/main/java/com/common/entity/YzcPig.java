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
 * 猪表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_pig")
public class YzcPig extends Model<YzcPig> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer pig_id;
    /**
     * 耳号
     */
	private String pig_ear_num;
    /**
     * 性别
     */
	private String pig_sex;
    /**
     * 栏号
     */
	private Integer pig_class;
    /**
     * 父耳号
     */
	private Integer pig_fa_ear;
    /**
     * 母耳号
     */
	private Integer pig_mo_ear;
    /**
     * 来源（自繁，购入）
     */
	private String pig_source;
    /**
     * 出生日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pig_birth;
    /**
     * 出生重量
     */
	private Double pig_weight;
    /**
     * 断奶重量
     */
	private Double pig_dn_weight;
    /**
     * 进场日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pig_enter_time;
    /**
     * 品级评定
     */
	private Integer pig_level;
    /**
     * 左奶头数
     */
	private Integer pig_letf_nipples;
    /**
     * 右奶头数
     */
	private Integer pig_right_nipples;
    /**
     * 是否阉割
     */
	private Integer pig_is_spay;
    /**
     * 健康状态
     */
	private String pig_health;
    /**
     * 淘汰日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pig_out_time;
    /**
     * 品种编号
     */
	private Integer pig_type_id;
    /**
     * 阶段编号
     */
	private Integer pig_step_id;
    /**
     * 描述（备注）
     */
	private String pig_desc;
    /**
     * 是否死亡（0，1）
     */
	private Integer pig_is_dead;


	public Integer getPig_id() {
		return pig_id;
	}

	public void setPig_id(Integer pig_id) {
		this.pig_id = pig_id;
	}

	public String getPig_ear_num() {
		return pig_ear_num;
	}

	public void setPig_ear_num(String pig_ear_num) {
		this.pig_ear_num = pig_ear_num;
	}

	public String getPig_sex() {
		return pig_sex;
	}

	public void setPig_sex(String pig_sex) {
		this.pig_sex = pig_sex;
	}

	public Integer getPig_class() {
		return pig_class;
	}

	public void setPig_class(Integer pig_class) {
		this.pig_class = pig_class;
	}

	public Integer getPig_fa_ear() {
		return pig_fa_ear;
	}

	public void setPig_fa_ear(Integer pig_fa_ear) {
		this.pig_fa_ear = pig_fa_ear;
	}

	public Integer getPig_mo_ear() {
		return pig_mo_ear;
	}

	public void setPig_mo_ear(Integer pig_mo_ear) {
		this.pig_mo_ear = pig_mo_ear;
	}

	public String getPig_source() {
		return pig_source;
	}

	public void setPig_source(String pig_source) {
		this.pig_source = pig_source;
	}

	public Date getPig_birth() {
		return pig_birth;
	}

	public void setPig_birth(Date pig_birth) {
		this.pig_birth = pig_birth;
	}

	public Double getPig_weight() {
		return pig_weight;
	}

	public void setPig_weight(Double pig_weight) {
		this.pig_weight = pig_weight;
	}

	public Double getPig_dn_weight() {
		return pig_dn_weight;
	}

	public void setPig_dn_weight(Double pig_dn_weight) {
		this.pig_dn_weight = pig_dn_weight;
	}

	public Date getPig_enter_time() {
		return pig_enter_time;
	}

	public void setPig_enter_time(Date pig_enter_time) {
		this.pig_enter_time = pig_enter_time;
	}

	public Integer getPig_level() {
		return pig_level;
	}

	public void setPig_level(Integer pig_level) {
		this.pig_level = pig_level;
	}

	public Integer getPig_letf_nipples() {
		return pig_letf_nipples;
	}

	public void setPig_letf_nipples(Integer pig_letf_nipples) {
		this.pig_letf_nipples = pig_letf_nipples;
	}

	public Integer getPig_right_nipples() {
		return pig_right_nipples;
	}

	public void setPig_right_nipples(Integer pig_right_nipples) {
		this.pig_right_nipples = pig_right_nipples;
	}

	public Integer getPig_is_spay() {
		return pig_is_spay;
	}

	public void setPig_is_spay(Integer pig_is_spay) {
		this.pig_is_spay = pig_is_spay;
	}

	public String getPig_health() {
		return pig_health;
	}

	public void setPig_health(String pig_health) {
		this.pig_health = pig_health;
	}

	public Date getPig_out_time() {
		return pig_out_time;
	}

	public void setPig_out_time(Date pig_out_time) {
		this.pig_out_time = pig_out_time;
	}

	public Integer getPig_type_id() {
		return pig_type_id;
	}

	public void setPig_type_id(Integer pig_type_id) {
		this.pig_type_id = pig_type_id;
	}

	public Integer getPig_step_id() {
		return pig_step_id;
	}

	public void setPig_step_id(Integer pig_step_id) {
		this.pig_step_id = pig_step_id;
	}

	public String getPig_desc() {
		return pig_desc;
	}

	public void setPig_desc(String pig_desc) {
		this.pig_desc = pig_desc;
	}

	public Integer getPig_is_dead() {
		return pig_is_dead;
	}

	public void setPig_is_dead(Integer pig_is_dead) {
		this.pig_is_dead = pig_is_dead;
	}

	@Override
	protected Serializable pkVal() {
		return this.pig_id;
	}

}
