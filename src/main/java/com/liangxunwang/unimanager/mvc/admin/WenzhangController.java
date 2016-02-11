package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.Wenzhang;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.query.WenzhangQuery;
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
@RequestMapping("/wenzhang")
public class WenzhangController extends ControllerConstants {
    @Autowired
    @Qualifier("wenzhangService")
    private ListService wenzhangService;


    @RequestMapping("list")
    public String list(ModelMap map, WenzhangQuery query){
        List<Wenzhang> list = (List<Wenzhang>) wenzhangService.list(query);
        map.put("list", list);
        return "/wenzhang/list";
    }


}
