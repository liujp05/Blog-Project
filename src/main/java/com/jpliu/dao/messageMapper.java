package com.jpliu.dao;

import com.jpliu.model.message;
import com.jpliu.model.messageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface messageMapper {
    long countByExample(messageExample example);

    int deleteByExample(messageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(message record);

    int insertSelective(message record);

    List<message> selectByExampleWithBLOBs(messageExample example);

    List<message> selectByExample(messageExample example);

    message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") message record, @Param("example") messageExample example);

    int updateByExampleWithBLOBs(@Param("record") message record, @Param("example") messageExample example);

    int updateByExample(@Param("record") message record, @Param("example") messageExample example);

    int updateByPrimaryKeySelective(message record);

    int updateByPrimaryKeyWithBLOBs(message record);

    int updateByPrimaryKey(message record);
}