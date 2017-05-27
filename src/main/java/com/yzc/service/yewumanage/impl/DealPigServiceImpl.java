package com.yzc.service.yewumanage.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.dao.YzcDealPigMapper;
import com.common.dao.YzcOrdersMapper;
import com.common.entity.DealPigInfo;
import com.common.entity.YzcDealPig;
import com.yzc.dao.yewumanage.DealPigDao;
import com.yzc.service.yewumanage.DealPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Created by wangfujie on 2017/4/30.
 */
@Service
public class DealPigServiceImpl extends ServiceImpl<YzcDealPigMapper , YzcDealPig> implements DealPigService {

    @Autowired
    private YzcOrdersMapper ordersMapper;

    @Autowired
    private DealPigDao pigDao;

    @Override
    public Page<Map<String, Object>> getDealPigPage(Page<Map<String, Object>> page, String startDate, String endDate,String deal_type, String ear_num, String par_name) {
        page.setRecords(pigDao.getDealPigList(page,startDate,endDate,deal_type,ear_num,par_name));
        return page;
    }

    @Override
    public Map<String, Object> geDealPigById(int deal_id) {
        return pigDao.geDealPigById(deal_id);
    }

    @Override
    public boolean insertDealPigInfo(DealPigInfo dealPigInfo) {
        boolean bool = false;
        int result = ordersMapper.insert(dealPigInfo.getOrders());
        if(result > 0){
            bool = insertBatch(dealPigInfo.getDealPigList());
        }
        return bool;
    }
}
