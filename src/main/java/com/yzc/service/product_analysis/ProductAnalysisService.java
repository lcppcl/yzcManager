package com.yzc.service.product_analysis;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
public interface ProductAnalysisService {
    /*
     * 猪场价值评估
     */
    List<Map<String,Object>> getPigValue(String date);

    /*
     * 死亡率分析
     */
    List<Map<String,Object>> getMortalityByDate(String date);

    /*
     * 生产效率分析
     */
    List<Map<String,Object>> getProductivityByDate(String type);

    /*
     * 受胎率分析
     */
    List<Map<String,Object>> getPregnancyByDate(String oneDate, String twoDate);
}
