package com.yzc.dao.yewumanage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/30.
 */
@Repository
public interface DealPigDao {

    /*
    * 获取所有信息
    */
    List<Map<String , Object>> getDealPigList(Pagination page ,
                                              @Param("startDate") String startDate,
                                              @Param("endDate") String endDate,
                                              @Param("deal_type") String deal_type,
                                              @Param("ear_num") String ear_num,
                                              @Param("par_name") String par_name
    );

    /*
     * 通过id获取信息
     */
    Map<String , Object> geDealPigById(@Param("deal_id") int deal_id);
}
