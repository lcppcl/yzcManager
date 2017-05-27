package com.yzc.service.pig_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcFeedRecord;
import com.common.entity.YzcFeeds;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
public interface FeedRecordService extends IService<YzcFeedRecord> {

    /**
     * 获取饲养记录（分页）
     */
    Page<Map<String,Object>> getFeedPage(Page<Map<String,Object>> page , String startDate , String endDate , String feed_user,Integer cla_id);

    /**
     * 通过id查询
     */
    Map<String,Object> getFeedById(int id);

    /**
     * 获取饲料列表
     */
    List<YzcFeeds> getFeedsList();
}
