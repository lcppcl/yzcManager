package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcVariety;
import com.yzc.service.pig_manage.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangfujie on 2017/4/18.
 * 品种管理
 */
@RestController
@RequestMapping("/pig_manage/variety")
public class VarietyController {
    @Autowired
    private VarietyService service;

    /**
     * 新增品种
     */
    @RequestMapping("/addVariety")
    public boolean addVariety(YzcVariety variety){
        return service.insert(variety);
    }

    /**
     * 删除品种
     */
    @RequestMapping("/delVariety")
    public boolean delVariety(int vid){
        return service.deleteById(vid);
    }

    /**
     * 通过id查询
     */
    @RequestMapping("/getVarietyById")
    public YzcVariety getVarietyById(int id){
        return service.selectById(id);
    }


    /**
     * 修改品种
     */
    @RequestMapping("/updateVariety")
    public boolean updateVariety(YzcVariety variety){
        return service.updateById(variety);
    }

    /**
     * 查询品种
     */
    @RequestMapping("/queryVariety")
    public Page<YzcVariety> queryVariety(int current , int size , String name){
        Page<YzcVariety> page = new Page<>(current,size);
        String sqlWhere = "var_name like '%" + name + "%'" + " or var_desc like '%" + name + "%'";
        service.selectPage(page,new EntityWrapper<YzcVariety>().where(sqlWhere));
        return page;
    }
}
