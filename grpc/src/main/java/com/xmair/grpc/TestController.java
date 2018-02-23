package com.xmair.grpc;

import com.xmair.core.entity.framedb.EmpData;
import com.xmair.core.mapper.framedb.EmpDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {



    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public  EmpData Test(){
     //   EmpData user=  userMapper.selectByPrimaryKey("06645");
        EmpData user=new EmpData();
        user.setCnName("hehehehehhhhhhhhhh");
        if(user==null){
            return  new EmpData();
        }
        return  user;


    }
}
