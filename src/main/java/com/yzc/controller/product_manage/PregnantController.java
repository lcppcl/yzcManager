package com.yzc.controller.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcBreedRecord;
import com.common.entity.YzcPregnantRecord;
import com.yzc.service.product_manage.PregnantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@RestController
@RequestMapping("/product_manage/pregnant")
public class PregnantController {

    @Autowired
    private PregnantService service;

    /**
     * 查询怀孕记录
     */
    @RequestMapping("/getPageList")
    public Page<Map<String , Object>> getPageList(int current , int size , String m_ear_num){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.getPageList(page,m_ear_num);
        return page;
    }

    /**
     * 新增或修改怀孕记录
     */
    @RequestMapping("/insertPregnant")
    public boolean insertPregnant(YzcPregnantRecord record){
        return service.insert(record);
    }

    /**
     * 删除怀孕记录
     */
    @RequestMapping("/deletePregnant")
    public boolean deletePregnant(int id){
        return service.deletePreById(id);
    }

    /**
     * 通过id查询怀孕记录
     */
    @RequestMapping("/getPregnantById")
    public Map<String , Object> getPregnantById(int id){
        return service.getPregnantById(id);
    }

    /**
     * 查询怀孕记录下拉框
     */
    @RequestMapping("/getPregnantList")
    public List<YzcPregnantRecord> getPregnantList(){
        return service.getPregnantList();
    }

    /**
     * 查询怀孕记录下拉框
     */
    @RequestMapping("/getBreedInfoByPreId")
    public Map<String , Object> getBreedInfoByPreId(int pre_id){
        return service.getBreedInfoByPreId(pre_id);
    }

}
