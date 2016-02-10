package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends ControllerConstants {

    @Autowired
    @Qualifier("memberService")
    private ListService memberService;

    @RequestMapping("list")
    public String list(ModelMap map, MemberQuery query){
        List<Member> list = (List<Member>) memberService.list(query);
        map.put("list", list);
        return "/role/list";
    }

    @RequestMapping("add")
    public String add(ModelMap map, MemberQuery query){
        List<Member> list = (List<Member>) memberService.list(query);
        map.put("list", list);
        return "/role/add";
    }

    @RequestMapping("addPiao")
    public String addPiao(ModelMap map){
        return "/piao/addpiao";
    }

}
