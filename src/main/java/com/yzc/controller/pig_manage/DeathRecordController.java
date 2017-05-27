package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcDeathRecord;
import com.yzc.service.pig_manage.DeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@RestController
@RequestMapping("/pig_manage/death_record")
public class DeathRecordController {

    @Autowired
    private DeathRecordService recordService;

    /**
     * 分页查询
     */
    @RequestMapping("/getDeathRecordPage")
    public Page<Map<String , Object>> getDeathRecordPage(int current , int size , String startDate , String endDate , String ear_num){
        Page<Map<String , Object>> page = new Page<>(current,size);
        recordService.getDeathRecordPage(page,startDate,endDate,ear_num);
        return page;
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/getDeathRecordById")
    public Map<String , Object> getDeathRecordById(int id){
        return recordService.getDeathRecordById(id);
    }

    /**
     *  添加或修改
     */
    @RequestMapping("/insertOrUpdate")
    public boolean insertOrUpdate(YzcDeathRecord record){
        return recordService.insertOrUpdateDeathRecord(record);
    }

    /**
     *  删除
     */
    @RequestMapping("/deleteById")
    public boolean deleteById(int id){
        return recordService.deleteById(id);
    }


}
