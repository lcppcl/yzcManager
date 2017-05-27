package com.yzc.service.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcBornRecord;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 * 分娩管理
 */
public interface ChildbirthService {

	/*
	 * 查询
	 */
    Page<Map<String, Object>> getPageList(Page<Map<String, Object>> page , String  ear_num);

    /*
     * 添加
     */
    int addInfo(YzcBornRecord record) ;
    /*
     * 删除
     */
    int delById(int id) ;
    /*
     * 根据id查询
     */
    Map<String,Object> getById(int id);
    /*
     * 修改
     */
    int updateInfo(YzcBornRecord record);
}
