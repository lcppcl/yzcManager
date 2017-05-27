package com.yzc.service.product_manage;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.entity.YzcBreedRecord;
import com.common.entity.YzcPregnantRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
public interface PregnantService extends IService<YzcPregnantRecord> {

    /**
     * 查询page
     */
    Page<Map<String , Object>> getPageList(Page<Map<String , Object>> page , String ear_num);

    /**
     * 通过id查询怀孕记录
     */
    Map<String , Object> getPregnantById(int pre_id);

    /**
     * 通过id删除
     */
    boolean deletePreById(int id);

    /**
     * 查询怀孕记录下拉框
     */
    List<YzcPregnantRecord> getPregnantList();

    /**
     * 通过怀孕id获取配种信息
     */
    Map<String , Object> getBreedInfoByPreId(int pre_id);

}
