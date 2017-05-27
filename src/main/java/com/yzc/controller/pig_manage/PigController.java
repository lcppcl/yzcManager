package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.dao.YzcStepMapper;
import com.common.entity.YzcClass;
import com.common.entity.YzcPig;
import com.common.entity.YzcStep;
import com.common.entity.YzcVariety;
import com.yzc.service.pig_manage.ClassesService;
import com.yzc.service.pig_manage.VarietyService;
import com.yzc.service.pig_manage.YzcPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 * 猪类管理
 */
@RestController
@RequestMapping("/pig_manage/pig")
public class PigController {

    @Autowired
    private YzcPigService pigService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private VarietyService varietyService;
    @Autowired
    private YzcStepMapper stepMapper;

    /**
     * 猪管理（公猪，母猪查询）
     */
    @RequestMapping("/getPigPageByParams")
    public Page<Map<String , Object>> getPigPageByParams(int current , int size , String startDate , String endDate , String ear_num , String pig_sex , Integer var_id){
        Page<Map<String , Object>> page = new Page<>(current,size);
        pigService.getPigPageByParams(page,startDate,endDate,ear_num,pig_sex,var_id);
        return page;
    }

    /**
     * 育种猪管理
     */
    @RequestMapping("/getSeedPigPage")
    public Page<Map<String , Object>> getSeedPigPage(int current , int size){
        Page<Map<String , Object>> page = new Page<>(current,size);
        pigService.getSeedPigPage(page);
        return page;
    }

    /**
     * 验证耳号
     */
    @RequestMapping("/validateEar")
    public boolean validateEar(String ear_num){
        return pigService.validateEar(ear_num);
    }

    /**
     * 添加或修改
     */
    @RequestMapping("/addOrUpdate")
    public boolean addOrUpdate(YzcPig pig){
        return pigService.insertOrUpdate(pig);
    }

    /**
     * 通过id查询
     */
    @RequestMapping("/getPigById")
    public Map<String , Object> getPigById(int pig_id , String pig_sex){
        return pigService.getPigById(pig_id,pig_sex);
    }

    /**
     * 删除
     */
    @RequestMapping("/delPigById")
    public boolean delPigById(int pig_id){
        return pigService.delPigById(pig_id);
    }

    /**
     * 获取猪（耳号）列表
     */
    @RequestMapping("/getPigList")
    public List<YzcPig> getPigList(String pig_sex){
        return pigService.getPigList(pig_sex);
    }

    /**
     * 获取品种列表
     */
    @RequestMapping("/getVarietyList")
    public List<YzcVariety> getVarietyList(){
        return varietyService.selectList(null);
    }

    /**
     * 获取阶段列表
     */
    @RequestMapping("/getStepList")
    public List<YzcStep> getStepList(){
        return stepMapper.selectList(null);
    }

    /**
     * 获取猪栏列表
     */
    @RequestMapping("/getClassesList")
    public List<YzcClass> getClassesList(){
        return classesService.selectList(null);
    }
}
