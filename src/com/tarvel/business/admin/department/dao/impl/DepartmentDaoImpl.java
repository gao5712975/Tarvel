package com.tarvel.business.admin.department.dao.impl;

import com.tarvel.basic.dao.impl.BasicDaoImpl;
import com.tarvel.business.admin.department.dao.DepartmentDao;
import com.tarvel.business.admin.department.po.DepartmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**机构管理xml映射
 * Created by Yuan on 2015/7/3 0003.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BasicDaoImpl<DepartmentEntity> implements DepartmentDao {
    public List<Map<String, Object>> findDepartmentChildren(Map<String, Object> map) {
        return null;
    }

    public List<Map<String, Object>> findDepartmentParent(Map<String, Object> map) {
        return null;
    }

    public void insertDepartment(Map<String, Object> map) {

    }

    public void updateDepartment(Map<String, Object> map) {

    }

    public void deleteDepartment(Map<String, Object> map) {

    }
}
