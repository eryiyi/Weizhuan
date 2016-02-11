package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.GuizeDao;
import com.liangxunwang.unimanager.dao.PiaoDao;
import com.liangxunwang.unimanager.model.Guize;
import com.liangxunwang.unimanager.model.PiaoAdd;
import com.liangxunwang.unimanager.service.DeleteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("guizeService")
public class GuizeService implements ListService ,SaveService, DeleteService{
    @Autowired
    @Qualifier("guizeDao")
    private GuizeDao guizeDao;

    @Override
    public Object list(Object object) throws ServiceException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Guize> lists = guizeDao.lists(map);
        return lists;
    }

    @Override
    public Object save(Object object) throws ServiceException {
        Guize piaoAdd = (Guize) object;
        piaoAdd.setGuize_id(UUIDFactory.random());
        guizeDao.save(piaoAdd);
        return null;
    }


    @Override
    public Object delete(Object object) throws ServiceException {
        guizeDao.delete();
        return null;
    }

}
