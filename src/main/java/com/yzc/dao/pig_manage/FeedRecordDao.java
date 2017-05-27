package com.yzc.dao.pig_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/25.
 */
@Repository
public interface FeedRecordDao {

    /**
     * 获取饲养记录（分页）
     */
    List<Map<String,Object>> getFeedList(Pagination page,
                                         @Param("startDate") String startDate,
                                         @Param("endDate") String endDate,
                                         @Param("feed_user") String feed_user,
                                         @Param("cla_id") Integer cla_id);

    /**
     * 通过id查询
     */
    Map<String,Object> getFeedById(@Param("id") int id);

}
