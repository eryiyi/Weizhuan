package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.Guize;
import com.liangxunwang.unimanager.model.PiaoAdd;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/1/29.
 */
@Repository("guizeDao")
public interface GuizeDao {
    /**
     * 查询信息
     */
    List<Guize> lists(Map<String, Object> map);

    //保存我们自己的萌宝
    void save(Guize guize);

    //删除
    void delete();
}
