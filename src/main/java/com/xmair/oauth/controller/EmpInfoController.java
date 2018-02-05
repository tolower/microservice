package com.xmair.oauth.controller;

import com.xmair.oauth.entity.framedb.EmpData;
import com.xmair.oauth.mapper.framedb.EmpDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/empinfo")
public class EmpInfoController {
    @Autowired
    private EmpDataMapper userMapper;

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)

    public EmpData mybatistest(String pcode){


        EmpData user=  userMapper.selectByPrimaryKey(pcode);
        if(user==null){
            return  new EmpData();
        }
        return  user;

    }
}
