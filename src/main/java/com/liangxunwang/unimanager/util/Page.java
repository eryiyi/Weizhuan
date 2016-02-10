package com.liangxunwang.unimanager.util;

/**
 * Created by liuzwei on 2015/1/31.
 */
public class Page {
    private int index;
    private boolean current;  //是否当前页

    private int page; // 欲要显示页数
    private int defaultSize = 10;  //每页默认显示数据条数
    private long pageCount; //共几页
    private long count;//数据总共条数

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
