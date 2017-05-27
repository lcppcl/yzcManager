package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 猪栏
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_class")
public class YzcClass extends Model<YzcClass> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 猪舍号
     */
	private Integer cla_gra_id;
    /**
     * 栏名称
     */
	private String cla_name;
    /**
     * 面积
     */
	private String cla_eara;
    /**
     * 饲养员id
     */
	private Integer cla_breeder;
    /**
     * 是否完好
     */
	private String cla_is_intact;
    /**
     * 备注
     */
	private String cla_desc;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCla_gra_id() {
		return cla_gra_id;
	}

	public void setCla_gra_id(Integer cla_gra_id) {
		this.cla_gra_id = cla_gra_id;
	}

	public String getCla_name() {
		return cla_name;
	}

	public void setCla_name(String cla_name) {
		this.cla_name = cla_name;
	}

	public String getCla_eara() {
		return cla_eara;
	}

	public void setCla_eara(String cla_eara) {
		this.cla_eara = cla_eara;
	}

	public Integer getCla_breeder() {
		return cla_breeder;
	}

	public void setCla_breeder(Integer cla_breeder) {
		this.cla_breeder = cla_breeder;
	}

	public String getCla_is_intact() {
		return cla_is_intact;
	}

	public void setCla_is_intact(String cla_is_intact) {
		this.cla_is_intact = cla_is_intact;
	}

	public String getCla_desc() {
		return cla_desc;
	}

	public void setCla_desc(String cla_desc) {
		this.cla_desc = cla_desc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
