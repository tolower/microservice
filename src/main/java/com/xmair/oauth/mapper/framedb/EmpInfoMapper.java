package com.xmair.oauth.mapper.framedb;

import com.xmair.oauth.entity.EmpInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmpInfoMapper {
    @Select("SELECT * FROM tb_emp_data")
    List<EmpInfo> getAll();

    @Select("SELECT * FROM tb_emp_data WHERE mf_id = #{id}")
    EmpInfo getOne(String id);

}
