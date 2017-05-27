package com.yzc.controller.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcBornRecord;
import com.yzc.service.product_manage.ChildbirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@RestController
@RequestMapping("/product_manage/childbirth")
public class ChildbirthController {
    @Autowired
    private ChildbirthService childbirthService;

    /*
    * 查询
    */
    @RequestMapping("/getPageList")
    public Page<Map<String, Object>> getPageList(int current , int size , String  ear_num){
        Page<Map<String , Object>> page = new Page<>(current , size);
        childbirthService.getPageList(page,ear_num);
        return page;
    }

    /*
     * 添加
     */
    @RequestMapping("/addInfo")
    public int addInfo(YzcBornRecord record){
        return childbirthService.addInfo(record);
    }

    /*
     * 删除
     */
    @RequestMapping("/delById")
    public int delById(int id){
        return childbirthService.delById(id);
    }

    /*
     * 根据id查询
     */
    @RequestMapping("/getById")
    public Map<String,Object> getById(int id){
        return childbirthService.getById(id);
    }

    /*
     * 修改
     */
    @RequestMapping("/updateInfo")
    public int updateInfo(YzcBornRecord record){
        return childbirthService.updateInfo(record);
    }

}
