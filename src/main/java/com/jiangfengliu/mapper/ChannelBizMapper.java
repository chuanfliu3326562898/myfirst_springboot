package com.jiangfengliu.mapper;

import com.jiangfengliu.model.Channel;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface ChannelBizMapper {

    /**
     * 根据是否精选和名字分页查询
     *
     * @param isHandPick 是否精选
     * @param name       迷糊查询名字
     * @param start      分页开始
     * @param limit      偏移量
     * @return
     */
    List<Channel> selectByHandPickOrNameForPage(@Param("ids") Collection<Long> ids,
        @Param("isHandPick") Integer isHandPick, @Param("name") String name, @Param("start") Integer start,
        @Param("limit") Integer limit);

    /**
     * 根据是否精选和名字分页查询总量
     *
     * @param isHandPick 是否精选
     * @param name       迷糊查询名字
     * @return
     */
    Integer selectByHandPickOrNameForCount(@Param("ids") Collection<Long> ids, @Param("isHandPick") Integer isHandPick,
        @Param("name") String name);

    /**
     * 根据id更新
     *
     * @param record
     * @return
     */
    Integer updateSelectiveById(Channel record);

    /**
     * 选择性插入返回逐渐
     *
     * @param record
     * @return
     */
    Integer insertSelectiveReturnId(Channel record);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    Integer deleteById(@Param("id") Long id);

    /**
     * 根据id批量查询
     * @param ids
     * @return
     */
    List<Channel> selectByChannelIds(@Param("ids") Collection<Long> ids);
}