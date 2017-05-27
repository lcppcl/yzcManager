package com.yzc.controller.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcBreedRecord;
import com.yzc.service.product_manage.BreedManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@RestController
@RequestMapping("/product_manage/breed")
public class BreedManageController {
    @Autowired
    private BreedManageService breedService;

    /**
     * 查询配种记录
     */
    @RequestMapping("/getPageList")
    public Page<Map<String , Object>> getPageList(int current , int size , String mo_ear_num , String fu_ear_num){
        Page<Map<String , Object>> page = new Page<>(current , size);
        breedService.getPageList(page,mo_ear_num,fu_ear_num);
        return page;
    }

    /**
     * 查询配种耳号
     */
    @RequestMapping("/getBreedEarNum")
    public List<Map<String , Object>> getBreedEarNum(){
        return breedService.getBreedEarNum();
    }

    /**
     * 新增或修改
     */
    @RequestMapping("/insertBreedRecord")
    public boolean insertBreedRecord(YzcBreedRecord record){
        return breedService.insertOrUpdate(record);
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteBreedRecord")
    public boolean deleteBreedRecord(int id){
        return breedService.deleteById(id);
    }

    /**
     * 通过id查询
     */
    @RequestMapping("/getBreedById")
    public Map<String , Object> getBreedById(int id){
        return breedService.getBreedById(id);
    }

}
