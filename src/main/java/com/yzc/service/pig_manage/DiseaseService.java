package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcIllRecord;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
public interface DiseaseService extends IService<YzcIllRecord> {

    /**
     * 获取病例记录（分页）
     */
    Page<Map<String,Object>> getIllPage(Page<Map<String,Object>> page , String ill_name , String ear_num) ;

    /**
     * 通过id查询
     */
    Map<String,Object> getIllById(int id);

}
