package com.yzc.dao.count;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@Repository
public interface TableCountDao {

    /**
     * 客户交易来往统计
     */
    List<Map<String,Object>> getUserCountByDate(@Param("oneDate") String oneDate, @Param("twoDate") String twoDate, @Param("par_name") String par_name);

    /**
     * 猪类销售统计
     */
    List<Map<String,Object>> getPigSellCountByDate(@Param("oneDate") String oneDate, @Param("twoDate") String twoDate, @Param("par_name") String par_name);

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
