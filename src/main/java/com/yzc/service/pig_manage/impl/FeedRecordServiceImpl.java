package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcFeedRecordMapper;
import com.common.dao.YzcFeedsMapper;
import com.common.entity.YzcFeedRecord;
import com.common.entity.YzcFeeds;
import com.yzc.dao.pig_manage.FeedRecordDao;
import com.yzc.service.pig_manage.FeedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Service
public class FeedRecordServiceImpl extends ServiceImpl<YzcFeedRecordMapper , YzcFeedRecord> implements FeedRecordService {

    @Autowired
    private FeedRecordDao recordDao;
    @Autowired
    private YzcFeedsMapper feedsMapper;

    @Override
    public Page<Map<String, Object>> getFeedPage(Page<Map<String, Object>> page, String startDate, String endDate, String feed_user,Integer cla_id) {
        page.setRecords(recordDao.getFeedList(page,startDate,endDate,feed_user,cla_id));
        return page;
    }

    @Override
    public Map<String, Object> getFeedById(int id) {
        return recordDao.getFeedById(id);
    }

    @Override
    public List<YzcFeeds> getFeedsList() {
        return feedsMapper.selectList(null);
    }
}
