package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.AdminDao;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by liuzh on 2015/8/12.
 */
@Service("adminService")
public class AdminService implements UpdateService , ExecuteService{

    @Autowired
    @Qualifier("adminDao")
    private AdminDao adminDao;
    @Override
    public Object update(Object object) {
        if (object instanceof Object[]){
            Object[] params = (Object[]) object;
            String empId = (String) params[0];
            String roleId = (String) params[1];
            adminDao.updateRole(empId, roleId);
        }
        return null;
    }

    @Override
    public Object execute(Object object) throws ServiceException {
        Object[] params = (Object[]) object;
        String userId = (String) params[0];
        String userPass = (String) params[1];
        adminDao.updatePass(userId, userPass);
        return null;
    }
}
