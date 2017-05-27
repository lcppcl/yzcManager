package com.yzc.service.count;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
public interface TableCountService {
    /**
     * 客户交易来往统计
     */
    List<Map<String,Object>> getUserCountByDate(String oneDate, String twoDate, String par_name);

    /**
     * 猪类销售统计
     */
    List<Map<String,Object>> getPigSellCountByDate(String oneDate, String twoDate, String par_name);

    /**
     * 月统计报表1
     */
    List<Map<String,Object>> getMonthCountTab1ByDate(String date);

    /**
     * 月统计报表2
     */
    List<Map<String,Object>> getMonthCountTab2ByDate(String date);

    /**
     * 存栏统计
     */
    List<Map<String,Object>> getLivestockCountByDate(String date);

}
