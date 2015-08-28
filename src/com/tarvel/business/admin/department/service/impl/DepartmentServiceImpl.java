package com.tarvel.business.admin.department.service.impl;

import com.tarvel.business.admin.department.dao.DepartmentDao;
import com.tarvel.business.admin.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 机构服务
 * Created by Yuan on 2015/7/3 0003.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Map<String, Object>> findDepartmentChildren(Map<String, Object> map) {
        return departmentDao.findDepartmentChildren(map);
    }

    public List<Map<String, Object>> findDepartmentParent(Map<String, Object> map) {
        return departmentDao.findDepartmentParent(map);
    }

    public String insertDepartment(Map<String, Object> map) {
        map.put("parent_id",map.get("depart_code").toString());
        map.put("create_time",new Date());
        map.put("update_time",new Date());
        map.put("valid",0);
        departmentDao.insertDepartment(map);
        return map.get("depart_code").toString();
    }

    public void updateDepartment(Map<String, Object> map) {
        map.put("update_time",new Date());
        departmentDao.updateDepartment(map);
    }

    public void deleteDepartment(Map<String, Object> map) {
        departmentDao.deleteDepartment(map);
    }
}
