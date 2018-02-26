package com.xmair.restapi.controller;
import com.xmair.core.entity.framedb.TbEmpDataAll;
import com.xmair.core.mapper.framedb.TbEmpDataAllMapper;
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
* @date 2018-02-26 13:43:47
* @version
*/
@RestController
@RequestMapping(value = "/tbempdataall")
@ApiVersion(1)
public class TbEmpDataAllController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private TbEmpDataAllMapper mapper;


    @ApiOperation(value="获取单条记录", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResultBean<TbEmpDataAll> get(String id){
        TbEmpDataAll item=  mapper.selectByPrimaryKey(id);
        if(item!=null){
            return new ResultBean<TbEmpDataAll>(item);
        }else {
            return new ResultBean<TbEmpDataAll>(ResultCodeEnum.FAILTURE.toString(),"找不到该记录",null);
        }
    }


    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ResultBean<List<TbEmpDataAll>> getList(){
        List<TbEmpDataAll> list=  mapper.selectAll();
        ResultBean<List<TbEmpDataAll>> resultBean=new ResultBean<List<TbEmpDataAll>>(list);
        return  resultBean;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultBean<Integer> create(TbEmpDataAll item){
        int  result= mapper.insert(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultBean<Integer> update(TbEmpDataAll item){
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
    public ResultBean<Integer> delete(TbEmpDataAll item){
        int  result=  mapper.updateByPrimaryKey(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

}

