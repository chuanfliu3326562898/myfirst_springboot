package com.jiangfengliu.mapper;

import com.jiangfengliu.dao.SpecialtyDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpecialtyMapper {
    
    @Select("select * from specialty where province = #{province};")
    List<SpecialtyDao> getSpecialtyList(String province);
    
}