package com.yzc.dao.pig_manage;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/24.
 */
@Repository
public interface ClassesDao {

    /**
     * 分页查询（通过管理员查询猪栏信息）
     */
    List<Map<String , Object>> getClassesList(Pagination page , @Param("m_name")  String m_name , @Param("cla_name")  String cla_name , @Param("gra_id")  Integer gra_id);

    /**
     * 通过猪栏名或id查询猪栏信息
     */
    Map<String , Object> getClassInfo(@Param("id") int id , @Param("c_name") String c_name);
}
