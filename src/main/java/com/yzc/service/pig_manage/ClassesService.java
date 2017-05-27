package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcClass;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
public interface ClassesService extends IService<YzcClass> {

    /**
     * 分页查询（通过管理员查询猪栏信息）
     */
    Page<Map<String , Object>> getPageClass(Page<Map<String, Object>> page , String m_name , String cla_name , Integer gra_id);

    /**
     * 通过猪栏名或id查询猪栏信息
     */
    Map<String , Object> getClassInfo(int id , String c_name);

}
