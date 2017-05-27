package com.yzc.service.product_manage.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcBornRecordMapper;
import com.common.dao.YzcBreedRecordMapper;
import com.common.dao.YzcPregnantRecordMapper;
import com.common.entity.YzcBornRecord;
import com.common.entity.YzcBreedRecord;
import com.common.entity.YzcPregnantRecord;
import com.yzc.dao.product_manage.BreedManageDao;
import com.yzc.service.product_manage.BreedManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@Service
public class BreedManageServiceImpl extends ServiceImpl<YzcBreedRecordMapper , YzcBreedRecord> implements BreedManageService {
    @Autowired
    private BreedManageDao breedManageDao;
    @Autowired
    private YzcPregnantRecordMapper pregnantRecordMapper;
    @Autowired
    private YzcBornRecordMapper bornRecordMapper;

    @Override
    public Page<Map<String, Object>> getPageList(Page<Map<String, Object>> page, String mo_ear_num, String fu_ear_num) {
        page.setRecords(breedManageDao.getPageList(page,mo_ear_num,fu_ear_num));
        return page;
    }

    @Override
    public List<Map<String, Object>> getBreedEarNum() {
        return breedManageDao.getBreedEarNum();
    }

    @Override
    public Map<String, Object> getBreedById(int id) {
        return breedManageDao.getBreedById(id);
    }

    @Override
    public boolean deleteBreedRecord(int id) {
        List<YzcPregnantRecord> recordList = pregnantRecordMapper.selectList(new EntityWrapper<YzcPregnantRecord>().eq("pre_bre_id",id));
        if(recordList != null && recordList.size() > 0){
            for (YzcPregnantRecord record : recordList) {
                int pre_id = record.getPre_id();
                bornRecordMapper.delete(new EntityWrapper<YzcBornRecord>().eq("bor_pre_id",pre_id));
            }
        }
        bornRecordMapper.delete(new EntityWrapper<YzcBornRecord>().eq("bor_bre_id",id));
        return deleteById(id);
    }
}
