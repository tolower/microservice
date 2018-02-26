package com.xmair.restapi.controller;
import com.xmair.core.entity.TbWeixinUser;
import com.xmair.core.mapper.test1.TbWeixinUserMapper;
import com.xmair.core.util.ResultBean;
import com.xmair.core.util.ResultCodeEnum;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.xmair.restapi.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* <p>
    * </p>
*
* @author wuzuquan
* @date 2018-02-26 13:45:57
* @version
*/
@RestController
@RequestMapping(value = "/tbweixinuser")
@ApiVersion(1)
public class TbWeixinUserController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private TbWeixinUserMapper mapper;


    @ApiOperation(value="获取单条记录", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResultBean<TbWeixinUser> get(String id){
        TbWeixinUser item=  mapper.selectByPrimaryKey(id);
        if(item!=null){
            return new ResultBean<TbWeixinUser>(item);
        }else {
            return new ResultBean<TbWeixinUser>(ResultCodeEnum.FAILTURE.toString(),"找不到该记录",null);
        }
    }


    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ResultBean<List<TbWeixinUser>> getList(){
        List<TbWeixinUser> list=  mapper.selectAll();
        ResultBean<List<TbWeixinUser>> resultBean=new ResultBean<List<TbWeixinUser>>(list);
        return  resultBean;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultBean<Integer> create(TbWeixinUser item){
        int  result= mapper.insert(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultBean<Integer> update(TbWeixinUser item){
        int  result=  mapper.updateByPrimaryKey(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

    @RequestMapping(value = "/deleteByID",method = RequestMethod.POST)
    public ResultBean<Integer> delete(String id){
        int  result=  mapper.deleteByPrimaryKey(id);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultBean<Integer> delete(TbWeixinUser item){
        int  result=  mapper.updateByPrimaryKey(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

}

