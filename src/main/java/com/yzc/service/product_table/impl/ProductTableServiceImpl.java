package com.yzc.service.product_table.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.yzc.dao.product_table.ProductTableDao;
import com.yzc.service.product_table.ProductTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Service
public class ProductTableServiceImpl implements ProductTableService {

    @Autowired
    private ProductTableDao tableDao;


    @Override
    public Page<Map<String, Object>> boarPigProductQuery(Page<Map<String, Object>> page, String ear_num, int grade_id , int class_id) {
        page.setRecords(tableDao.boarPigProductQuery(page,ear_num,grade_id,class_id));
        return page;
    }

    @Override
    public Page<Map<String, Object>> sowPigProductQuery(Page<Map<String, Object>> page, String ear_num, int grade_id , int class_id) {
        page.setRecords(tableDao.sowPigProductQuery(page,ear_num,grade_id,class_id));
        return page;
    }

    @Override
    public Page<Map<String, Object>> getClassDetail(Page<Map<String, Object>> page, String ear_num, int grade_id , int class_id) {
        page.setRecords(tableDao.getClassDetail(page,ear_num,grade_id,class_id));
        return page;
    }

    @Override
    public Page<Map<String, Object>> getPigFeedsCost(Page<Map<String, Object>> page, int grade_id) {
        page.setRecords(tableDao.getPigFeedsCost(page,grade_id));
        return page;
    }
}
