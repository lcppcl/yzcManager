package com.yzc.service.yewumanage.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcOrdersMapper;
import com.common.dao.YzcPurchaseRecordMapper;
import com.common.entity.YzcCaiGouSubmit;
import com.common.entity.YzcOrders;
import com.common.entity.YzcPurchaseRecord;
import com.yzc.dao.yewumanage.CaiGouDao;
import com.yzc.service.yewumanage.CaiGouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangfujie on 2017/4/18.
 */
@Service
public class CaiGouServiceImpl extends ServiceImpl<YzcPurchaseRecordMapper , YzcPurchaseRecord> implements CaiGouService {

    @Autowired
    private YzcOrdersMapper ordersMapper;

    @Autowired
    private CaiGouDao caiGouDao;

    @Override
    public Page<Map<String , Object>> queryPurByName(Page<Map<String , Object>> page,String startDate, String endDate, String content) {
        page.setRecords(caiGouDao.queryPurByName(page , startDate,endDate,content));
        return page;
    }

    @Override
    public Map<String , Object> getPurInfoById(int pur_id) {
        return caiGouDao.getPurInfoById(pur_id);
    }

    @Override
    public boolean insertCiaGouInfo(YzcCaiGouSubmit submit) {
        boolean bool = false;
        int result = ordersMapper.insert(submit.getOrders());
        if(result > 0){
            bool = insertBatch(submit.getRecordList());
        }
        return bool;
    }

}
