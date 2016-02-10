package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
public class AdminController extends ControllerConstants {

    @Autowired
    @Qualifier("adminService")
    private UpdateService adminUpdateService;

    @Autowired
    @Qualifier("adminService")
    private ExecuteService adminExecuteService;

    @RequestMapping("/updateRole")
    @ResponseBody
    public String updateRole(String empId, String roleId){
        if (StringUtil.isNullOrEmpty(empId) || StringUtil.isNullOrEmpty(roleId)){
            return toJSONString(ERROR_1);
        }
        Object[] params = new Object[]{empId, roleId};
        adminUpdateService.update(params);
        return toJSONString(SUCCESS);
    }

    /**
     * �޸�����
     * @param session
     * @param ePass ԭ����
     * @param pass  ������
     * @return
     */
    @RequestMapping("/changePass")
    @ResponseBody
    public String changePass(HttpSession session, String ePass, String pass){
        try {
            Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
            if (manager == null){
                return toJSONString(ERROR_2);//û�е�¼
            }
            //���ԭ��������֤��ͨ�����ø���
            if (!manager.getPassword().equals(ePass)){
                return toJSONString(ERROR_3);
            }
            Object[] params = new Object[]{manager.getId(), pass};
            adminExecuteService.execute(params);
            session.removeAttribute(ACCOUNT_KEY);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

    @RequestMapping("/toChangePass")
    public String toChanagePass(){
        return "/admin/pass";
    }
}
