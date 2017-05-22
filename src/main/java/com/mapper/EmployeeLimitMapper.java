package com.mapper;

import com.pojo.EmployeeLimit;
import com.pojo.EmployeeLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeLimitMapper {
    int countByExample(EmployeeLimitExample example);

    int deleteByExample(EmployeeLimitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeLimit record);

    int insertSelective(EmployeeLimit record);

    List<EmployeeLimit> selectByExample(EmployeeLimitExample example);

    EmployeeLimit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeLimit record, @Param("example") EmployeeLimitExample example);

    int updateByExample(@Param("record") EmployeeLimit record, @Param("example") EmployeeLimitExample example);

    int updateByPrimaryKeySelective(EmployeeLimit record);

    int updateByPrimaryKey(EmployeeLimit record);
}