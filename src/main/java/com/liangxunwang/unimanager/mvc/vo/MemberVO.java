package com.liangxunwang.unimanager.mvc.vo;

import com.liangxunwang.unimanager.model.Member;

/**
 * Created by liuzwei on 2015/1/31.
 */
public class MemberVO extends Member {
    private String universityName;//大学名称
    private String levelName;
    private String jfcount;//积分
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getJfcount() {
        return jfcount;
    }

    public void setJfcount(String jfcount) {
        this.jfcount = jfcount;
    }
}
