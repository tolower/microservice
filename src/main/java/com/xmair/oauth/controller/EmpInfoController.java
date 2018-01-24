package com.xmair.oauth.controller;

import com.xmair.oauth.entity.EmpInfo;
import com.xmair.oauth.entity.User;
import com.xmair.oauth.mapper.UserMapper;
import com.xmair.oauth.mapper.framedb.EmpInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/empinfo")
public class EmpInfoController {
    @Autowired
    private EmpInfoMapper userMapper;

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    @ResponseBody
    public  EmpInfo mybatistest(String pcode){


        EmpInfo user=  userMapper.getOne(pcode);
        if(user==null){
            return  new EmpInfo();
        }
        return  user;

    }
}
