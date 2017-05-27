package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcClass;
import com.yzc.service.pig_manage.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 * 猪栏管理
 */
@RestController
@RequestMapping("/pig_manage/class")
public class ClassesController {

    @Autowired
    private ClassesService service;

    /**
     * 分页查询（通过管理员查询猪栏信息）
     */
    @RequestMapping("/getPageClass")
    public Page<Map<String , Object>> getPageClass(int current , int size , String m_name , String cla_name , Integer gra_id){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.getPageClass(page , m_name , cla_name , gra_id);
        return page;
    }

    /**
     * 通过猪栏名或id查询猪栏信息
     */
    @RequestMapping("/getClassInfo")
    public Map<String , Object> getClassInfo(int id , String c_name){
        return service.getClassInfo(id, c_name);
    }

    /**
     *  添加或修改猪栏信息
     */
    @RequestMapping("/insertOrUpdate")
    public boolean insertOrUpdate(YzcClass yzcClass){
        return service.insertOrUpdate(yzcClass);
    }

    /**
     *  删除
     */
    @RequestMapping("/deleteClass")
    public boolean deleteClass(int id){
        return service.deleteById(id);
    }

}
