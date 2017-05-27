package com.yzc.dao.product_analysis;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/19.
 */
@Repository
public interface ProductAnalysisDao {

    /*
    * 猪场价值评估
    */
    List<Map<String,Object>> getPigValue(@Param("date") String date);

    /*
     * 死亡率分析
     */
    List<Map<String,Object>> getMortalityByDate(@Param("date") String date);

    /**
     * 总产仔数
     */
    List<Map<String,Object>> getBornProductivity();

    /*
     * 各月配种次数
     */
    List<Map<String,Object>> getMonthBreedsProductivity();

    /*
     * 受胎率分析
     */
    List<Map<String,Object>> getPregnancyByDate(@Param("oneDate") String oneDate , @Param("twoDate") String twoDate);

}
