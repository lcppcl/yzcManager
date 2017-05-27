package com.yzc.controller.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcFeedRecord;
import com.common.entity.YzcFeeds;
import com.yzc.service.pig_manage.FeedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 * 饲养记录
 */
@RestController
@RequestMapping("/pig_manage/feed_record")
public class FeedRecordController {

    @Autowired
    private FeedRecordService service;

    /**
     * 分页查询
     */
    @RequestMapping("/getFeedPage")
    public Page<Map<String , Object>> getFeedPage(int current , int size , String startDate , String endDate , String feed_user , Integer cla_id){
        Page<Map<String , Object>> page = new Page<>(current,size);
        service.getFeedPage(page,startDate,endDate,feed_user,cla_id);
        return page;
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/getFeedById")
    public Map<String , Object> getFeedById(int id){
        return service.getFeedById(id);
    }

    /**
     *  添加或修改
     */
    @RequestMapping("/insertOrUpdate")
    public boolean insertOrUpdate(YzcFeedRecord record){
        return service.insertOrUpdate(record);
    }

    /**
     *  删除
     */
    @RequestMapping("/deleteById")
    public boolean deleteById(int id){
        return service.deleteById(id);
    }

    /**
     *  获取饲料列表
     */
    @RequestMapping("/getFeedsList")
    public List<YzcFeeds> getFeedsList(){
        return service.getFeedsList();
    }

}
