package com.yzc.service.count.impl;

import com.yzc.dao.count.TableCountDao;
import com.yzc.service.count.TableCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@Service
public class TableCountServiceImpl implements TableCountService {

    @Autowired
    private TableCountDao tableDao;

    @Override
    public List<Map<String, Object>> getUserCountByDate(String oneDate, String twoDate, String par_name) {
        return tableDao.getUserCountByDate(oneDate, twoDate, par_name);
    }

    @Override
    public List<Map<String, Object>> getPigSellCountByDate(String oneDate, String twoDate, String par_name) {
        return tableDao.getPigSellCountByDate(oneDate, twoDate, par_name);
    }

    @Override
    public List<Map<String, Object>> getMonthCountTab1ByDate(String date) {
        return tableDao.getMonthCountTab1ByDate(date);
    }

    @Override
    public List<Map<String, Object>> getMonthCountTab2ByDate(String date) {
        return tableDao.getMonthCountTab2ByDate(date);
    }

    @Override
    public List<Map<String, Object>> getLivestockCountByDate(String date) {
        return tableDao.getLivestockCountByDate(date);
    }
}
