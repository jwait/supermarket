package com.mapper;

import com.pojo.GoodsSum;
import com.pojo.GoodsSumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSumMapper {
    int countByExample(GoodsSumExample example);

    int deleteByExample(GoodsSumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSum record);

    int insertSelective(GoodsSum record);

    List<GoodsSum> selectByExample(GoodsSumExample example);

    GoodsSum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsSum record, @Param("example") GoodsSumExample example);

    int updateByExample(@Param("record") GoodsSum record, @Param("example") GoodsSumExample example);

    int updateByPrimaryKeySelective(GoodsSum record);

    int updateByPrimaryKey(GoodsSum record);
}