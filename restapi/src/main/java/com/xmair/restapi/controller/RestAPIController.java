package com.xmair.restapi.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.core.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restapi")
public class RestAPIController {
    @Autowired
    private EmpDataMapper empDataMapper;
    @RequestMapping(value = "/index")
    public String index(int number){
        System.out.println(20 / number);
        return "get index page successfully.";
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
