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
public interface DeathRecordDao {
    /**
     * 分页查询
     */
    List<Map<String , Object>> getDeathRecordList(Pagination page , @Param("startDate") String startDate , @Param("endDate") String endDate , @Param("ear_num") String ear_num);

    /**
     * 通过id查询信息
     */
    Map<String , Object> getDeathRecordById(@Param("id") int id);

}
