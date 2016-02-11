package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Children;
import com.liangxunwang.unimanager.model.Guize;
import com.liangxunwang.unimanager.model.Member;
import com.liangxunwang.unimanager.model.PiaoAdd;
import com.liangxunwang.unimanager.query.MemberQuery;
import com.liangxunwang.unimanager.service.DeleteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/guize")
public class GuizeController extends ControllerConstants {
    @Autowired
    @Qualifier("guizeService")
    private ListService guizeServiceList;

    @Autowired
    @Qualifier("guizeService")
    private SaveService guizeServiceSave;


    @Autowired
    @Qualifier("guizeService")
    private DeleteService guizeServiceDelete;


//    @RequestMapping("list")
//    public String list(ModelMap map, MemberQuery query){
//        List<PiaoAdd> list = (List<PiaoAdd>) childrenService.list(query);
//        map.put("list", list);
//        return "/children/list";
//    }


    @RequestMapping("add")
    public String add(){

        return "guize/addguize";
    }


    @RequestMapping("save")
    @ResponseBody
    public String save(Guize piaoAdd){
        //先删除现在的规则
        guizeServiceDelete.delete("");
        //插入新的规则
        guizeServiceSave.save(piaoAdd);
        return toJSONString(SUCCESS);
    }



    @RequestMapping("delete")
    @ResponseBody
    public String delete(String cid){
        guizeServiceDelete.delete(cid);
        return toJSONString(SUCCESS);
    }



    @RequestMapping("guizelist")
    public String subdo(ModelMap map, MemberQuery query) throws InterruptedException {
        final List<Guize> list = (List<Guize>) guizeServiceList.list(query);//这个是我们指定的规则
        map.put("list", list);
        return "/guize/list";
    }


    private static void sleepMinutes(long minutes) {
        try {
            TimeUnit.MINUTES.sleep(minutes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printCurrentTime() {
        System.out.printf("Current: %tF %<tT%n", System.currentTimeMillis());
    }


}
