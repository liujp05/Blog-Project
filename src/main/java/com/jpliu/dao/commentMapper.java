package com.jpliu.dao;

import com.jpliu.model.comment;
import com.jpliu.model.commentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface commentMapper {
    long countByExample(commentExample example);

    int deleteByExample(commentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(comment record);

    int insertSelective(comment record);

    List<comment> selectByExampleWithBLOBs(commentExample example);

    List<comment> selectByExample(commentExample example);

    comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") comment record, @Param("example") commentExample example);

    int updateByExampleWithBLOBs(@Param("record") comment record, @Param("example") commentExample example);

    int updateByExample(@Param("record") comment record, @Param("example") commentExample example);

    int updateByPrimaryKeySelective(comment record);

    int updateByPrimaryKeyWithBLOBs(comment record);

    int updateByPrimaryKey(comment record);
}