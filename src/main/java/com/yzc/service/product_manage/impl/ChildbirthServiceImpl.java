package com.yzc.service.product_manage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.dao.YzcBornRecordMapper;
import com.common.entity.YzcBornRecord;
import com.yzc.dao.product_manage.ChildbirthDao;
import com.yzc.service.product_manage.ChildbirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@Service
public class ChildbirthServiceImpl implements ChildbirthService {
    @Autowired
    private YzcBornRecordMapper recordMapper;
    @Autowired
    private ChildbirthDao childbirthDao;

    @Override
    public Page<Map<String, Object>> getPageList(Page<Map<String, Object>> page, String ear_num) {
        page.setRecords(childbirthDao.getPageList(page,ear_num));
        return page;
    }

    @Override
    public int addInfo(YzcBornRecord record) {
        return recordMapper.insert(record);
    }

    @Override
    public int delById(int id) {
        return recordMapper.deleteById(id);
    }

    @Override
    public Map<String, Object> getById(int id) {
        return childbirthDao.getById(id);
    }

    @Override
    public int updateInfo(YzcBornRecord record) {
        return recordMapper.updateById(record);
    }
}
