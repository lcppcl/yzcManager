package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcDeathRecordMapper;
import com.common.entity.YzcDeathRecord;
import com.yzc.dao.pig_manage.DeathRecordDao;
import com.yzc.service.pig_manage.DeathRecordService;
import com.yzc.service.pig_manage.YzcPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Service
public class DeathRecordServiceImpl extends ServiceImpl<YzcDeathRecordMapper , YzcDeathRecord> implements DeathRecordService {
    @Autowired
    private DeathRecordDao recordDao;
    @Autowired
    private YzcPigService pigService;

    @Override
    public Page<Map<String, Object>> getDeathRecordPage(Page<Map<String, Object>> page, String startDate, String endDate, String ear_num) {
        page.setRecords(recordDao.getDeathRecordList(page,startDate,endDate,ear_num));
        return page;
    }

    @Override
    public Map<String, Object> getDeathRecordById(int id) {
        return recordDao.getDeathRecordById(id);
    }

    @Override
    public boolean insertOrUpdateDeathRecord(YzcDeathRecord record) {
        if(record.getDea_id() == null){
            pigService.delPigById(record.getDea_ear());
        }
        return insertOrUpdate(record);
    }
}
