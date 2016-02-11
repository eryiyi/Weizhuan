package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.MemberDao;
import com.liangxunwang.unimanager.dao.WenzhangDao;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.model.Wenzhang;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.query.WenzhangQuery;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("wenzhangService")
public class WenzhangService implements ListService {
    @Autowired
    @Qualifier("wenzhangDao")
    private WenzhangDao wenzhangDao;

    @Override
    public Object list(Object object) throws ServiceException {
        WenzhangQuery query = (WenzhangQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(query.getTitle())) {
            map.put("title", query.getTitle());
        }
        List<Wenzhang> lists = wenzhangDao.listWenzhang(map);
        return lists;
    }


}
