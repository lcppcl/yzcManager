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
 * 猪舍
 * </p>
 *
 * @author wangfj
 * @since 2017-04-16
 */
@TableName("yzc_grade")
public class YzcGrade extends Model<YzcGrade> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer gra_id;
    /**
     * 猪舍名称
     */
	private String gra_name;
    /**
     * 猪栏数量
     */
	private Integer gra_class_num;
    /**
     * 描述
     */
	private String gra_desc;
    /**
     * 舍长（猪舍管理员）
     */
	private Integer gra_admin;
    /**
     * 建立日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date gra_build_time;


	public Integer getGra_id() {
		return gra_id;
	}

	public void setGra_id(Integer gra_id) {
		this.gra_id = gra_id;
	}

	public String getGra_name() {
		return gra_name;
	}

	public void setGra_name(String gra_name) {
		this.gra_name = gra_name;
	}

	public Integer getGra_class_num() {
		return gra_class_num;
	}

	public void setGra_class_num(Integer gra_class_num) {
		this.gra_class_num = gra_class_num;
	}

	public String getGra_desc() {
		return gra_desc;
	}

	public void setGra_desc(String gra_desc) {
		this.gra_desc = gra_desc;
	}

	public Integer getGra_admin() {
		return gra_admin;
	}

	public void setGra_admin(Integer gra_admin) {
		this.gra_admin = gra_admin;
	}

	public Date getGra_build_time() {
		return gra_build_time;
	}

	public void setGra_build_time(Date gra_build_time) {
		this.gra_build_time = gra_build_time;
	}

	@Override
	protected Serializable pkVal() {
		return this.gra_id;
	}

}
