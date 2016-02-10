package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.MemberDao;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.mvc.vo.MemberVO;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("memberService")
public class MemberService implements ListService , UpdateService{
    @Autowired
    @Qualifier("memberDao")
    private MemberDao memberDao;

    @Override
    public Object list(Object object) throws ServiceException {
        MemberQuery query = (MemberQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(query.getName())) {
            map.put("name", query.getName());
        }
        if (!StringUtil.isNullOrEmpty(query.getName())) {
            map.put("name", query.getName());
        }

        List<Member> lists = memberDao.listMemberByName(map);
        return lists;
    }

    @Override
    public Object update(Object object) {
        if (object instanceof Member){
            Member member = (Member) object;
            memberDao.update(member);
        }
        return null;
    }

}
