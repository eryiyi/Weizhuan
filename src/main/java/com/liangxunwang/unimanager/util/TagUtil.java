package com.liangxunwang.unimanager.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 自定义标签
 * Created by liuzwei on 2015/1/31.
 */
public class TagUtil {
    public static boolean permission(String thisPower, String ownPermission){
        return ownPermission.contains("all") || ownPermission.contains(thisPower);
    }
    public static String format(long time, String format) {
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        if(time == Long.MIN_VALUE || time == 0) {
            return "";
        }
        if(time == 100){
            return format1.format(new Date());
        }
        return format1.format(new Date(time));
    }
    public static List<Page> page(int index, int pageCount, int num) {
        boolean isPageCountGreaterThanPageNumber = pageCount < num;
        List<Page> list = new ArrayList<Page>();
        int begin = 0;
        if(!isPageCountGreaterThanPageNumber && index > num / 2){
            if(index >= pageCount-num / 2){
                begin = pageCount - num;
            } else {
                begin = index - num / 2;
            }
        }
        int end = isPageCountGreaterThanPageNumber ? pageCount : num;
        for (int i = 1; i <= end; i++) {
            Page page = new Page();
            page.setCurrent(i + begin == index);
            page.setIndex(i + begin);
            list.add(page);
        }
        return list;
    }
}
