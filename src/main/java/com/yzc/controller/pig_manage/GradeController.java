package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcGrade;
import com.yzc.service.pig_manage.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 * 猪舍管理
 */
@RestController
@RequestMapping("/pig_manage/grade")
public class GradeController {

    @Autowired
    private GradeService service;

    /**
     * 分页查询
     */
    @RequestMapping("getGradePage")
    public Page<Map<String , Object>> getGradePage(int current , int size , String emp_name , String gra_name){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.getGradePage(page,emp_name,gra_name);
        return page;
    }

    /**
     * 通过id查询
     */
    @RequestMapping("getGradeInfo")
    public Map<String , Object> getGradeInfo(int gra_id){
        return service.getGradeInfo(gra_id);
    }

    /**
     * 修改或新增
     */
    @RequestMapping("insertOrUpdate")
    public boolean insertOrUpdate(YzcGrade grade){
        return service.insertOrUpdate(grade);
    }

    /**
     * 通过id删除
     */
    @RequestMapping("deleteGrade")
    public boolean deleteGrade(int gra_id){

        return service.deleteById(gra_id);
    }

    /**
     * 获取猪舍列表
     */
    @RequestMapping("/getGradeList")
    public List<YzcGrade> getGradeList(){
        return service.selectList(null);
    }


}
