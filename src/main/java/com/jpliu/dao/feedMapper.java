package com.jpliu.dao;

import com.jpliu.model.feed;
import com.jpliu.model.feedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface feedMapper {
    long countByExample(feedExample example);

    int deleteByExample(feedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(feed record);

    int insertSelective(feed record);

    List<feed> selectByExample(feedExample example);

    feed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") feed record, @Param("example") feedExample example);

    int updateByExample(@Param("record") feed record, @Param("example") feedExample example);

    int updateByPrimaryKeySelective(feed record);

    int updateByPrimaryKey(feed record);
}