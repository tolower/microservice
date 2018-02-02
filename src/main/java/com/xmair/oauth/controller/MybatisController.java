package com.xmair.oauth.controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xmair.oauth.entity.TBWeixinUser;
import com.xmair.oauth.entity.User;
import com.xmair.oauth.entity.framedb.EmpData;
import com.xmair.oauth.mapper.framedb.EmpDataMapper;
import com.xmair.oauth.mapper.test1.TBWeixinUserMapper;
import com.xmair.oauth.mapper.test1.User1Mapper;
import com.xmair.oauth.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private TBWeixinUserMapper weixinUserMapper;

    @Autowired
    private EmpDataMapper empDataMapper;
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = user1Mapper.getAll();
        return users;
    }

    @ApiIgnore
    @RequestMapping("/getUser")
    public User getUser(String id) {
        User user = user1Mapper.getOne(id);
        return user;
    }


    @ApiIgnore
    @RequestMapping("/getWeixinUser")
    public TBWeixinUser getUser() {
        TBWeixinUser user = weixinUserMapper.selectByPrimaryKey("11112");
        return user;
    }


    @RequestMapping("/getOracleUser")
    public PageEntity getOUser() {
        PageEntity result=new PageEntity();
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

    @RequestMapping("/add")
    public void save(User user) {
        user1Mapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        user1Mapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }

}