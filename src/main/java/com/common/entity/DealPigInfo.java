package com.common.entity;

import java.util.List;

/**
 * Created by wangfujie on 2017/4/30.
 */
public class DealPigInfo {

    private YzcOrders orders;
    private List<YzcDealPig> dealPigList;

    public YzcOrders getOrders() {
        return orders;
    }

    public void setOrders(YzcOrders orders) {
        this.orders = orders;
    }

    public List<YzcDealPig> getDealPigList() {
        return dealPigList;
    }

    public void setDealPigList(List<YzcDealPig> dealPigList) {
        this.dealPigList = dealPigList;
    }
}
