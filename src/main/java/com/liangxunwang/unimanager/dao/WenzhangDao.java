package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.model.Wenzhang;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/1/29.
 */
@Repository("wenzhangDao")
public interface WenzhangDao {

    /**
     * 查询所有的文章信息
     */
    List<Wenzhang> listWenzhang(Map<String, Object> map);

}
