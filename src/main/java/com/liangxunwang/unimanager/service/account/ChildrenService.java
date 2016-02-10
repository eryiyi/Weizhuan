package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.ChildrenDao;
import com.liangxunwang.unimanager.dao.MemberDao;
import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.*;
import com.liangxunwang.unimanager.util.Constants;
import com.liangxunwang.unimanager.util.DateUtil;
import com.liangxunwang.unimanager.util.StringUtil;
import com.liangxunwang.unimanager.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("childrenService")
public class ChildrenService implements ListService ,SaveService, DeleteService, UpdateService{
    @Autowired
    @Qualifier("childrenDao")
    private ChildrenDao childrenDao;

    @Override
    public Object list(Object object) throws ServiceException {
        MemberQuery query = (MemberQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(query.getName())) {
            map.put("name", query.getName());
        }
        List<Children> lists = childrenDao.lists(map);
        return lists;
    }

    @Override
    public Object save(Object object) throws ServiceException {
        Children advert = (Children) object;
//        advert.setId(UUIDFactory.random());
        childrenDao.save(advert);
        return null;
    }

    @Override
    public Object delete(Object object) throws ServiceException {
        if (object instanceof  String){
            String cid = (String) object;
            childrenDao.delete(cid);
        }
        return null;
    }

    @Override
    public Object update(Object object) {
        if (object instanceof Children){
            Children member = (Children) object;
            childrenDao.update(member);
        }
        return null;
    }
}
