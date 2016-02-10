package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.ChildrenDao;
import com.liangxunwang.unimanager.dao.PiaoDao;
import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.PiaoAdd;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.DeleteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.ServiceException;
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
@Service("piaoService")
public class PiaoService implements ListService ,SaveService, DeleteService{
    @Autowired
    @Qualifier("piaoDao")
    private PiaoDao piaoDao;

    @Override
    public Object list(Object object) throws ServiceException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<PiaoAdd> lists = piaoDao.lists(map);
        return lists;
    }

    @Override
    public Object save(Object object) throws ServiceException {
        PiaoAdd piaoAdd = (PiaoAdd) object;
        piaoAdd.setPid(UUIDFactory.random());
        piaoDao.save(piaoAdd);
        return null;
    }

    @Override
    public Object delete(Object object) throws ServiceException {
        piaoDao.delete();
        return null;
    }
}
