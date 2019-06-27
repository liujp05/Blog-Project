package com.jpliu.dao;

import com.jpliu.model.question;
import com.jpliu.model.questionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface questionMapper {
    long countByExample(questionExample example);

    int deleteByExample(questionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(question record);

    int insertSelective(question record);

    List<question> selectByExampleWithBLOBs(questionExample example);

    List<question> selectByExample(questionExample example);

    question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") question record, @Param("example") questionExample example);

    int updateByExampleWithBLOBs(@Param("record") question record, @Param("example") questionExample example);

    int updateByExample(@Param("record") question record, @Param("example") questionExample example);

    int updateByPrimaryKeySelective(question record);

    int updateByPrimaryKeyWithBLOBs(question record);

    int updateByPrimaryKey(question record);
}