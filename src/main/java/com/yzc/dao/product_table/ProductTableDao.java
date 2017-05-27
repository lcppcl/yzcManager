package com.yzc.dao.product_table;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Repository
public interface ProductTableDao {

    /*
    * 公猪生产成绩
    */
    List<Map<String , Object>> boarPigProductQuery(Pagination page , @Param("ear_num") String ear_num , @Param("grade_id") int grade_id , @Param("class_id") int class_id);

    /*
    * 母猪生产成绩
    */
    List<Map<String , Object>> sowPigProductQuery(Pagination page , @Param("ear_num") String ear_num , @Param("grade_id") int grade_id , @Param("class_id") int class_id);

    /**
     * 存栏明细
     */
    List<Map<String , Object>> getClassDetail(Pagination page ,  @Param("ear_num") String ear_num , @Param("grade_id") int grade_id , @Param("class_id") int class_id);

    /**
     * 猪群饲养成本
     */
    List<Map<String , Object>> getPigFeedsCost(Pagination page , @Param("grade_id") int grade_id);

}
