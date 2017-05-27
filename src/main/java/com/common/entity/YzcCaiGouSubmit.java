package com.common.entity;

import java.util.List;

/**
 * Created by wangfujie on 2017/4/30.
 */
public class YzcCaiGouSubmit {
    
    private List<YzcPurchaseRecord> recordList;
    private YzcOrders orders;

    public List<YzcPurchaseRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<YzcPurchaseRecord> recordList) {
        this.recordList = recordList;
    }

    public YzcOrders getOrders() {
        return orders;
    }

    public void setOrders(YzcOrders orders) {
        this.orders = orders;
    }
}
