package com.xmair.restapi.controller;
import com.xmair.core.entity.framedb.TbEmpDataAll;
import com.xmair.core.exception.ExceptionEnum;
import com.xmair.core.mapper.framedb.TbEmpDataAllMapper;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.ApiOperation;
import com.xmair.restapi.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
* <p>
    * </p>
*
* @author wuzuquan
* @date 2018-05-07 08:20:55
* @version
*/
@RestController
@RequestMapping(value = "/tbempdataall")
@ApiVersion(1)
public class TbEmpDataAllController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private TbEmpDataAllMapper mapper;


    @ApiOperation(value="获取单条记录", notes="根据url的id来获取详细信息")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResultBean<TbEmpDataAll> get(String id){
        TbEmpDataAll item=  mapper.selectByPrimaryKey(id);
        if(item!=null){
            return new ResultBean<TbEmpDataAll>(item);
        }else {
            return new ResultBean<TbEmpDataAll>(ExceptionEnum.RESOURCE_NOT_FOUND,null,"找不到该记录",null);
        }
    }


    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ResultBean<List<TbEmpDataAll>> getList(){
        List<TbEmpDataAll> list=  mapper.selectAll();
        ResultBean<List<TbEmpDataAll>> resultBean=new ResultBean<List<TbEmpDataAll>>(list);
        return  resultBean;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultBean<String> create(@Validated TbEmpDataAll item){
        int  result= mapper.insert(item);
        logger.info("create TbEmpDataAll success,record,{}"+ JsonUtil.bean2Json(item));
        ResultBean<String> resultBean=new ResultBean<String>("");
        return  resultBean;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultBean<String> update(@Validated TbEmpDataAll item){
        int  result=  mapper.updateByPrimaryKey(item);
        logger.info("update TbEmpDataAll success,record,{}"+ JsonUtil.bean2Json(item));
        ResultBean<String> resultBean=new ResultBean<String>("");
        return  resultBean;
    }

    @RequestMapping(value = "/deleteByID",method = RequestMethod.POST)
    public ResultBean<Integer> delete(String id){
        int  result=  mapper.deleteByPrimaryKey(id);
        logger.info("delete TbEmpDataAll success,record id,{}"+ id);
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

