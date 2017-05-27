package com.yzc.service.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcBreedRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
public interface BreedManageService extends IService<YzcBreedRecord> {

    /**
     * 查询配种记录
     */
    Page<Map<String , Object>> getPageList(Page<Map<String , Object>> page , String mo_ear_num , String fu_ear_num);


    /**
     * 查询配种耳号
     */
    List<Map<String , Object>> getBreedEarNum();

    /**
     * 通过id查询
     */
    Map<String , Object> getBreedById(int id);

    /**
     * 通过id删除
     */
    boolean deleteBreedRecord(int id);

}
