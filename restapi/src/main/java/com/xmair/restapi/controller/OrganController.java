package com.xmair.restapi.controller;

import com.xmair.core.entity.framedb.A1001;
import com.xmair.core.mapper.framedb.A1001Mapper;
import com.xmair.core.util.JsonUtil;
import com.xmair.core.util.ResultBean;
import com.xmair.core.exception.ExceptionEnum;
import com.xmair.restapi.apiversion.ApiVersion;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.AnyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* <p>
    * </p>
*
* @author wuzuquan
* @date 2018-03-06 10:39:43
* @version
*/
@RestController
@RequestMapping(value = "/organ")
@ApiVersion(1)
public class OrganController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private A1001Mapper mapper;


    @ApiOperation(value="获取单条记录", notes="根据url的id来获取详细信息")
    @RequestMapping(value = "/get",method = RequestMethod.GET)

    public ResultBean<A1001> get(String id){
        A1001 item=  mapper.selectByPrimaryKey(id);
        if(item!=null){
            return new ResultBean<A1001>(item);
        }else {
            return new ResultBean<A1001>(ExceptionEnum.RESOURCE_NOT_FOUND,null,"找不到该记录",null);
        }
    }


    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ResultBean<List<A1001>> getList(String organCode){
        List<A1001> list=  mapper.queryForList(organCode);
        ResultBean<List<A1001>> resultBean=new ResultBean<List<A1001>>(list);

        return  resultBean;
    }


}




