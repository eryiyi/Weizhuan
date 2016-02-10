package com.liangxunwang.unimanager.util;

import com.liangxunwang.unimanager.service.ExecuteService;

import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuzwei on 2015/5/17.
 */
public class CommonUtil {
    private static ExecutorService threadPool = null;
    public static ExecutorService getThreadPool(){
        if (threadPool == null){
            threadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        }
        return threadPool;
    }

    public static String StripHtml(String content){
        //<p>段落替换为换�? �?
        content=content.replaceAll("<p.*?>","rn");
        //<br><br/>替换为换�? �?
        content=content.replaceAll("<brs*/?>","rn");
        //去掉其它�?<>之间的东�? �?
        content=content.replaceAll("<.*?>","");
        //还原HTML �?
        //content=HTMLDecoder.decode(content);
        return content;
    }

    /**
     * 注：\n 回车(\u000a)
     * \t 水平制表�?(\u0009)
     * \s 空格(\u0008)
     * \r 换行(\u000d)
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static void main(String[] args){
        String str = "aksdhfkjasdf \n asdflkasdjfl \n alsdjflaksdjf \r";
        String rStr = CommonUtil.replaceBlank(str);
        System.out.print(rStr);
    }

}
