package com.jiangfengliu.dao;

import com.jiangfengliu.mapper.ChannelBizMapper;
import com.jiangfengliu.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Auther: Yummyxl
 * Company: 跟谁学<p>
 * @Date: 2019/4/18 14:49
 */

@Component
public class ChannelDao {

    @Autowired
    private ChannelBizMapper channelBizMapper;



    /**
     * 根据是否精选和名字分页查询
     *
     * @param isHandPick 是否精选
     * @param name       迷糊查询名字
     * @param start      分页开始
     * @param limit      偏移量
     * @return
     */
    public List<Channel> selectByHandPickOrNameForPage(Collection<Long> ids, Integer isHandPick, String name, Integer start, Integer limit) {
        if (name == null || name.trim().length() == 0) {
            name = null;
        }
        return channelBizMapper.selectByHandPickOrNameForPage(ids, isHandPick, name, start, limit);
    }

    /**
     * 根据是否精选和名字分页查询总量
     *
     * @param isHandPick 是否精选
     * @param name       迷糊查询名字
     * @return
     */
    public Integer selectByHandPickOrNameForCount(Collection<Long> ids, Integer isHandPick, String name) {
        if (name == null || name.trim().length() == 0) {
            name = null;
        }
        return channelBizMapper.selectByHandPickOrNameForCount(ids, isHandPick, name);
    }

    /**
     * 根据id更新
     *
     * @param record
     * @return
     */
    public Integer updateSelectiveById(Channel record) {
        return channelBizMapper.updateSelectiveById(record);
    }

    /**
     * 选择性插入返回逐渐
     *
     * @param record
     * @return
     */
    public Integer insertSelectiveReturnId(Channel record) {
        return channelBizMapper.insertSelectiveReturnId(record);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return channelBizMapper.deleteById(id);
    }

    /**
     * 根据id批量查询
     * @param ids
     * @return
     */
    public List<Channel> selectByChannelIds(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }

        return channelBizMapper.selectByChannelIds(ids);
    }


}
