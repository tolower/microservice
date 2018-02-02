package com.xmair.oauth.mapper.test1;

import com.xmair.oauth.entity.TBWeixinUser;

public interface TBWeixinUserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(TBWeixinUser record);

    int insertSelective(TBWeixinUser record);

    TBWeixinUser selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(TBWeixinUser record);

    int updateByPrimaryKey(TBWeixinUser record);
}