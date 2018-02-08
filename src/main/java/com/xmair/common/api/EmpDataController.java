package com.xmair.common.api;

import com.xmair.common.entity.framedb.EmpData;
import com.xmair.common.mapper.framedb.EmpDataMapper;
import com.xmair.common.util.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiVersion(2)
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public EmpData getByID2(String pcode){
        EmpData user=  userMapper.selectByPrimaryKey(pcode);
        user.setCnName("hehehehehhhhhhhhhh");
        if(user==null){
            return  new EmpData();
        }
        return  user;

    }
}
