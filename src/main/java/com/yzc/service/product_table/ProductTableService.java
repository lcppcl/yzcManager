package com.yzc.service.product_table;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
public interface ProductTableService {

    /*
    * 公猪生产成绩
    */
    Page<Map<String , Object>> boarPigProductQuery(Page<Map<String , Object>> page , String ear_num , int grade_id , int class_id);

    /*
    * 公猪生产成绩
    */
    Page<Map<String , Object>> sowPigProductQuery(Page<Map<String , Object>> page , String ear_num , int grade_id , int class_id);

    /**
     * 存栏明细
     */
    Page<Map<String , Object>> getClassDetail(Page<Map<String , Object>> page , String ear_num , int grade_id , int class_id);

    /**
     * 猪群饲养成本
     */
    Page<Map<String , Object>> getPigFeedsCost(Page<Map<String , Object>> page , int grade_id);

}
