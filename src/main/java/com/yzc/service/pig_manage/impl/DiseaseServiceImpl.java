package com.yzc.service.pig_manage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcIllRecordMapper;
import com.common.entity.YzcIllRecord;
import com.yzc.dao.pig_manage.DiseaseDao;
import com.yzc.service.pig_manage.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Service
public class DiseaseServiceImpl extends ServiceImpl<YzcIllRecordMapper , YzcIllRecord> implements DiseaseService {

    @Autowired
    private DiseaseDao diseaseDao;

    @Override
    public Page<Map<String, Object>> getIllPage(Page<Map<String, Object>> page, String ill_name , String ear_num) {
        page.setRecords(diseaseDao.getIllPage(page,ill_name,ear_num));
        return page;
    }

    @Override
    public Map<String, Object> getIllById(int id) {
        return diseaseDao.getIllById(id);
    }
}
