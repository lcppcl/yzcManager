package com.yzc.controller.yewumanage;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.common.entity.YzcPartner;
import com.yzc.service.yewumanage.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangfujie on 2017/4/30.
 */
@RestController
@RequestMapping("/yewumanage/partner")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    /**
     *分页查询
     */
    @RequestMapping("/getPageByName")
    public Page<YzcPartner> getPageByName(int current , int size , String par_name){
        Page<YzcPartner> page = new Page<>(current , size);
        partnerService.selectPage(page,new EntityWrapper<YzcPartner>().like("par_name",par_name));
        return page;
    }

    /**
     * 通过id查询
     */
    @RequestMapping("/getPartnerById")
    public YzcPartner getPartnerById(int id){
        return partnerService.selectById(id);
    }

    /**
     * 修改或新增
     */
    @RequestMapping("/updateOrInsert")
    public boolean updateOrInsert(YzcPartner partner){
        return partnerService.insertOrUpdate(partner);
    }

    /**
     * 通过id删除
     */
    @RequestMapping("/delPartnerById")
    public boolean delPartnerById(int id){
        return partnerService.deleteById(id);
    }

    /**
     * 获取列表
     */
    @RequestMapping("/getPartnerList")
    public List<YzcPartner> getPartnerList(){
        return partnerService.selectList(null);
    }

}
