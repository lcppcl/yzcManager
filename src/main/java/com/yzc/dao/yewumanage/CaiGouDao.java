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
public interface CaiGouDao {

    /*
     * 获取所有信息
    */
    List<Map<String , Object>> queryPurByName(Pagination page ,
                                               @Param("startDate") String startDate,
                                               @Param("endDate") String endDate,
                                               @Param("content") String content
    );

    /*
     * 通过id获取订单信息
     */
    Map<String , Object> getPurInfoById(@Param("pur_id") int pur_id);
}
