package com.xmair.oauth.mapper.framedb;

import com.xmair.oauth.entity.framedb.EmpData;

import java.util.List;

public interface EmpDataMapper {
    int deleteByPrimaryKey(String mfId);

    int insert(EmpData record);

    int insertSelective(EmpData record);

    EmpData selectByPrimaryKey(String mfId);

    List<EmpData> selectAll();
    int updateByPrimaryKeySelective(EmpData record);

    int updateByPrimaryKey(EmpData record);
}