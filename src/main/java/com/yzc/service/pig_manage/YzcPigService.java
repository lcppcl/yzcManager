package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcPig;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 */
public interface YzcPigService extends IService<YzcPig> {

    /**
     * 获取猪
     */
    Page<Map<String , Object>> getPigPageByParams(Page<Map<String , Object>> page , String startDate , String endDate , String ear_num , String pig_sex , Integer var_id);

    /**
     * 获取育种猪
     */
    Page<Map<String , Object>> getSeedPigPage(Page<Map<String , Object>> page);

    /**
     * 验证耳号
     */
    boolean validateEar(String ear_num);

    /**
     * 通过id查询
     */
    Map<String , Object> getPigById(int pig_id,String pig_sex);

    /**
     * 通过id查询
     */
    boolean delPigById(int pig_id);

    /**
     * 获取猪（耳号）列表
     */
    List<YzcPig> getPigList(String pig_sex);

}
