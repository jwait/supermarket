package com.mapper;

import com.pojo.SubType;
import com.pojo.SubTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubTypeMapper {
    int countByExample(SubTypeExample example);

    int deleteByExample(SubTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubType record);

    int insertSelective(SubType record);

    List<SubType> selectByExample(SubTypeExample example);

    SubType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubType record, @Param("example") SubTypeExample example);

    int updateByExample(@Param("record") SubType record, @Param("example") SubTypeExample example);

    int updateByPrimaryKeySelective(SubType record);

    int updateByPrimaryKey(SubType record);
}