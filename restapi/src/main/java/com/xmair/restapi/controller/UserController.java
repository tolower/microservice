package com.xmair.restapi.controller;
import com.xmair.core.entity.User;
import com.xmair.core.mapper.test1.UserMapper;
import com.xmair.core.util.ResultBean;
import com.xmair.core.util.ResultCodeEnum;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.xmair.restapi.apiversion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xmair.core.util.JsonUtil;
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
* @date 2018-02-27 16:54:34
* @version
*/
@RestController
@RequestMapping(value = "/user")
@ApiVersion(1)
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private UserMapper mapper;


    @ApiOperation(value="获取单条记录", notes="根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResultBean<User> get(String id){
        User item=  mapper.selectByPrimaryKey(id);
        if(item!=null){
            return new ResultBean<User>(item);
        }else {
            return new ResultBean<User>(ResultCodeEnum.RESOURCE_NOT_FOUND,"找不到该记录",null);
        }
    }


    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public ResultBean<List<User>> getList(){
        List<User> list=  mapper.selectAll();
        ResultBean<List<User>> resultBean=new ResultBean<List<User>>(list);
        return  resultBean;
    }

    /**
     * 是的发顺丰*/
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultBean<String> create(@Validated User item){
        int  result= mapper.insert(item);
        logger.info("create User success,record,{}"+ JsonUtil.bean2Json(item));
        ResultBean<String> resultBean=new ResultBean<String>("");
        return  resultBean;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultBean<String> update(@Validated User item){
        int  result=  mapper.updateByPrimaryKey(item);
        logger.info("update User success,record,{}"+ JsonUtil.bean2Json(item));
        ResultBean<String> resultBean=new ResultBean<String>("");
        return  resultBean;
    }

    @RequestMapping(value = "/deleteByID",method = RequestMethod.POST)
    public ResultBean<Integer> delete(String id){
        int  result=  mapper.deleteByPrimaryKey(id);
        logger.info("delete User success,record id,{}"+ id);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultBean<Integer> delete(User item){
        int  result=  mapper.updateByPrimaryKey(item);
        ResultBean<Integer> resultBean=new ResultBean<Integer>(result);
        return  resultBean;
    }

}

