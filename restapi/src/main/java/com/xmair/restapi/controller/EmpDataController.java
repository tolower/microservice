package com.xmair.restapi.controller;

import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import com.xmair.restapi.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
@ApiVersion(1)
public class EmpDataController {
    @Autowired
    private EmpDataMapper userMapper;


    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public EmpData getByID(String pcode){
        EmpData user=  userMapper.selectByPrimaryKey(pcode);
        if(user==null){
            return  new EmpData();
        }
        return  user;

    }

    @Autowired
    private HttpServletRequest request;

    @ApiVersion(2)
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public EmpData getByID2(String pcode){
        EmpData user= new EmpData();
               // userMapper.selectByPrimaryKey(pcode);
       // System.out.println(request.getRequestURL());
        user.setCnName("hehehehehhhhhhhhhh");
        if(user==null){
            return  new EmpData();
        }
        return  user;

    }
}
