package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.query.ChildrenQuery;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.DeleteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/children")
public class ChildrenController extends ControllerConstants {
    @Autowired
    @Qualifier("childrenService")
    private ListService childrenService;

    @Autowired
    @Qualifier("childrenService")
    private SaveService childrenServiceSave;

    @Autowired
    @Qualifier("childrenService")
    private DeleteService childrenServiceDel;


    @RequestMapping("list")
    public String list(ModelMap map, MemberQuery query){
        List<Children> list = (List<Children>) childrenService.list(query);
        map.put("list", list);
        return "/children/list";
    }

    @RequestMapping("save")
    @ResponseBody
    public String add(Children children){
        childrenServiceSave.save(children);
        return toJSONString(SUCCESS);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(String cid){
        childrenServiceDel.delete(cid);
        return toJSONString(SUCCESS);
    }
}
