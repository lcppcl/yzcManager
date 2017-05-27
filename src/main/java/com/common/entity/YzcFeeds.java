package com.common.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 饲料表
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_feeds")
public class YzcFeeds extends Model<YzcFeeds> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer fes_id;
    /**
     * 名称
     */
	private String fes_name;
    /**
     * 价格
     */
	private String fes_price;
    /**
     * 供应商id
     */
	private Integer fes_par_id;


	public Integer getFes_id() {
		return fes_id;
	}

	public void setFes_id(Integer fes_id) {
		this.fes_id = fes_id;
	}

	public String getFes_name() {
		return fes_name;
	}

	public void setFes_name(String fes_name) {
		this.fes_name = fes_name;
	}

	public String getFes_price() {
		return fes_price;
	}

	public void setFes_price(String fes_price) {
		this.fes_price = fes_price;
	}

	public Integer getFes_par_id() {
		return fes_par_id;
	}

	public void setFes_par_id(Integer fes_par_id) {
		this.fes_par_id = fes_par_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.fes_id;
	}

}
