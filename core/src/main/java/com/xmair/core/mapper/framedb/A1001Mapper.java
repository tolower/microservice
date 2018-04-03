package com.xmair.core.mapper.framedb;

import com.xmair.core.entity.framedb.A1001;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface A1001Mapper extends Mapper<A1001> {

    List<A1001> queryForList(String organCode);
}