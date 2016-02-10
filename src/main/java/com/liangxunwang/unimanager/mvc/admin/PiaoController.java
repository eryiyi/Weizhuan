package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Children;
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

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/piaoadd")
public class PiaoController extends ControllerConstants {
    @Autowired
    @Qualifier("piaoService")
    private ListService piaoService;

    @Autowired
    @Qualifier("piaoService")
    private SaveService piaoServiceSave;

    @Autowired
    @Qualifier("piaoService")
    private DeleteService piaoServiceDel;

    @Autowired
    @Qualifier("memberService")
    private UpdateService memberService;


    @Autowired
    @Qualifier("childrenService")
    private ListService childrenService;


//    @RequestMapping("list")
//    public String list(ModelMap map, MemberQuery query){
//        List<PiaoAdd> list = (List<PiaoAdd>) childrenService.list(query);
//        map.put("list", list);
//        return "/children/list";
//    }

    @RequestMapping("save")
    @ResponseBody
    public String add(PiaoAdd piaoAdd){
        //先删除现在的规则
        piaoServiceDel.delete("");
        //插入新的规则
        piaoServiceSave.save(piaoAdd);
        return toJSONString(SUCCESS);
    }



    @RequestMapping("delete")
    @ResponseBody
    public String delete(String cid){
        piaoServiceDel.delete(cid);
        return toJSONString(SUCCESS);
    }

    @Autowired
    @Qualifier("childrenService")
    private UpdateService childrenServiceUpdate;


    @RequestMapping("subdo")
    @ResponseBody
    public String subdo(ModelMap map, MemberQuery query) throws InterruptedException {
        final List<PiaoAdd> list = (List<PiaoAdd>) piaoService.list(query);//这个是我们指定的规则

        final List<Children> listChildren = (List<Children>) childrenService.list(query);//这个是我们要修改的宝宝名单

        //这个是规则
        PiaoAdd piaoAdd = list.get(0);
        if(piaoAdd != null){
            final String addone= piaoAdd.getAddone();
            final String addtwo= piaoAdd.getAddtwo();
            final String delone= piaoAdd.getDelone();
            final String deltwo= piaoAdd.getDeltwo();
            final  String datetime= piaoAdd.getDatetime();
            final String addshareone= piaoAdd.getAddshareone();
            final  String addsharetwo= piaoAdd.getAddsharetwo();
            final String handnum= piaoAdd.getHandnum();

            //另起线程去执行
            new Thread(new Runnable() {
                public void run() {
                    for(int i=0;i<Integer.parseInt(handnum);i++){
                            //去执行
                            if(listChildren != null){
                                for(Children children : listChildren){
                                    int ione = StringUtil.getIntMethod(Integer.parseInt(addone), Integer.parseInt(addtwo));//加
                                    int itwo = StringUtil.getIntMethod(Integer.parseInt(delone), Integer.parseInt(deltwo));//取消
                                    int ithree = StringUtil.getIntMethod(Integer.parseInt(addshareone), Integer.parseInt(addsharetwo));//人气
                                    Member member = new Member();
                                    member.setId(children.getCid());
                                    member.setNum(String.valueOf(Integer.parseInt(children.getNum()) + ione));
                                    member.setDnum(String.valueOf(Integer.parseInt(children.getDnum()) + itwo));
                                    member.setSharenum(String.valueOf(Integer.parseInt(children.getSharenum()) + ithree));
                                    //更新原始表数据
                                    memberService.update(member);

                                    //更新自己的宝宝列表--我们自己建的表，存放自己地宝宝的列表
                                    children.setNum(String.valueOf(Integer.parseInt(children.getNum())+ ione));
                                    children.setDnum(String.valueOf(Integer.parseInt(children.getDnum()) + itwo));
                                    children.setSharenum(String.valueOf(Integer.parseInt(children.getSharenum()) + ithree));
                                    childrenServiceUpdate.update(children);
                                }
                            }
                        Date now = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
                        System.out.println("执行：----第" + String.valueOf(i+1)+"次----时间："+dateFormat.format(now));
                        try {
                            Thread.sleep(Integer.parseInt(datetime)*60*1000);//延迟
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
        return toJSONString(SUCCESS);
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
