package com.xmair.restapi.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xmair.core.entity.TBWeixinUser;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.mapper.test1.TbWeixinUserMapper;
import com.xmair.core.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class MybatisController {


    @Autowired
    private TbWeixinUserMapper weixinUserMapper;

    @Autowired
    private EmpDataMapper empDataMapper;

    @ApiIgnore
    @RequestMapping("/getWeixinUser")
    public TBWeixinUser getUser() {
        TBWeixinUser user = weixinUserMapper.selectByPrimaryKey("11112");

        return user;
    }


    @RequestMapping("/getOracleUser")
    public PageBean getOUser() {
        PageBean result=new PageBean();
        PageHelper.startPage(1, 20);
        List<EmpData> list = empDataMapper.selectAll();

        for (EmpData country : list) {
            System.out.println("Country Name: " + country.getCnName());
        }
        result.setData(list);
        result.setPageNum(1);
        result.setPageSize(20);
        result.setTotal(((Page)list).getTotal());
        return result;
    }



}