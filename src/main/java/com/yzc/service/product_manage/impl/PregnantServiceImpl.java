package com.yzc.service.product_manage.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcBornRecordMapper;
import com.common.dao.YzcPregnantRecordMapper;
import com.common.entity.YzcBornRecord;
import com.common.entity.YzcBreedRecord;
import com.common.entity.YzcPregnantRecord;
import com.yzc.dao.product_manage.PregnantDao;
import com.yzc.service.product_manage.PregnantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/20.
 */
@Service
public class PregnantServiceImpl extends ServiceImpl<YzcPregnantRecordMapper,YzcPregnantRecord> implements PregnantService {
    @Autowired
    private YzcBornRecordMapper recordMapper;
    @Autowired
    private PregnantDao pregnantDao;

    @Override
    public Page<Map<String , Object>> getPageList(Page<Map<String , Object>> page, String ear_num) {
        page.setRecords(pregnantDao.getPageList(page,ear_num));
        return page;
    }

    @Override
    public Map<String, Object> getPregnantById(int pre_id) {
        return pregnantDao.getPregnantById(pre_id);
    }

    @Override
    public boolean deletePreById(int id) {
        recordMapper.delete(new EntityWrapper<YzcBornRecord>().eq("bor_pre_id",id));
        return deleteById(id);
    }

    @Override
    public List<YzcPregnantRecord> getPregnantList() {
        return selectList(null);
    }

    @Override
    public Map<String, Object> getBreedInfoByPreId(int pre_id) {
        return pregnantDao.getBreedInfoByPreId(pre_id);
    }

}
