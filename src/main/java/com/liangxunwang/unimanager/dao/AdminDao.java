package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by liuzwei on 2015/1/29.
 */
@Repository("adminDao")
public interface AdminDao {
    Admin findByUsername(String username);
    Admin findByEmpId(String empId);

    void add(Admin admin);

    void delete(String id);

    void updateRole(@Param(value = "empId")String empId, @Param(value = "roleId") String roleId);

    /**
     * 根据ID修改密码
     * @param id
     * @param pass
     */
    void updatePass(@Param(value = "id")String id, @Param(value = "pass") String pass);

    void updateCount(@Param(value = "empId")String empId, @Param(value = "count") String count);
}
