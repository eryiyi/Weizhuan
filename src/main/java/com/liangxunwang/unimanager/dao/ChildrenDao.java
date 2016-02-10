package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/1/29.
 */
@Repository("childrenDao")
public interface ChildrenDao {
    /**
     * 查询我们自己的所有萌宝信息
     */
    List<Children> lists(Map<String, Object> map);

    //保存我们自己的萌宝
    void save(Children children);

    //删除我们自己的宝宝
    void delete(String cid);

    //更新宝宝数据---最终一步
    void update(Children children);
}
