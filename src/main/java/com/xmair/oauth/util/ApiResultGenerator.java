package com.xmair.oauth.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**

 */
public final class ApiResultGenerator
{
    /**
     * 创建普通消息方法

     * @return
     */
    public static ApiResult result(String errCode,String errMsg)
    {
        //创建返回对象
        ApiResult apiResult =new ApiResult();
        apiResult.setErrMsg(errMsg);
        apiResult.setErrCode(errCode);

        return apiResult;
    }

    /**
     * 返回执行成功视图方法
     * @param result 执行成功后的返回内容
     * @return
     */
    public static ApiResult successResult(Object result)
    {
        //rows默认为0
        int rows = 0;
        //如果是集合
        if(result instanceof List)
        {
            //获取总数量
            rows = ((List)result).size();
        }
        return new ApiResult();
    }

    /**
     * 成功没有内容方法
     * @return
     */
    public static ApiResult successResult(HttpServletRequest request){

        return successResult("");
    }


}