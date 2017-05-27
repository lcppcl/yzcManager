package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcIllRecord;
import com.yzc.service.pig_manage.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 * 病历管理
 */
@RestController
@RequestMapping("/pig_manage/disease")
public class DiseaseController {
    @Autowired
    private DiseaseService service;

    /**
     * 获取病例记录（分页）
     */
    @RequestMapping("getIllPage")
    public Page<Map<String,Object>> getIllPage(int current , int size , String ill_name , String ear_num){
        Page<Map<String,Object>> page = new Page<>(current , size);
        service.getIllPage(page,ill_name,ear_num);
        return page;
    }

    /**
     * 通过id查询
     */
    @RequestMapping("getIllById")
    public Map<String,Object> getIllById(int id){
        return service.getIllById(id);
    }

    /**
     * 修改或新增
     */
    @RequestMapping("/updateOrInsert")
    public boolean updateOrInsert(YzcIllRecord record){
        return service.insertOrUpdate(record);
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteIll")
    public boolean deleteIll(int id){
        return service.deleteById(id);
    }
}
