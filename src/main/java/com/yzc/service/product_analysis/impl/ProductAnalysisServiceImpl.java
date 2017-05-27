package com.yzc.service.product_analysis.impl;

import com.common.utils.DateUtils;
import com.yzc.dao.product_analysis.ProductAnalysisDao;
import com.yzc.service.product_analysis.ProductAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@Service
public class ProductAnalysisServiceImpl implements ProductAnalysisService {
    @Autowired
    private ProductAnalysisDao analysisDao;

    @Override
    public List<Map<String, Object>> getPigValue(String date) {
        if(date == null || "".equals(date)){
            date = DateUtils.getFormatString(new Date(),"yyyy-MM");
        }
        return analysisDao.getPigValue(date);
    }

    @Override
    public List<Map<String, Object>> getMortalityByDate(String date) {
        return analysisDao.getMortalityByDate(date);
    }

    @Override
    public List<Map<String, Object>> getProductivityByDate(String type) {
        List<Map<String, Object>> list = null;
        if("总产仔数".equals(type)){
            list =  analysisDao.getBornProductivity();
        }

        if("各月配种次数".equals(type)){
            list =  analysisDao.getMonthBreedsProductivity();
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getPregnancyByDate(String oneDate, String twoDate) {
        return analysisDao.getPregnancyByDate(oneDate,twoDate);
    }
}
