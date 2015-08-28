package com.tarvel.business.admin.department.dao;

import com.tarvel.basic.dao.IBasicDao;
import com.tarvel.business.admin.department.po.DepartmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**机构管理xml映射
 * Created by Yuan on 2015/7/3 0003.
 */
public interface DepartmentDao extends IBasicDao<DepartmentEntity>{

    List<Map<String,Object>> findDepartmentChildren(Map<String, Object> map);

    List<Map<String,Object>> findDepartmentParent(Map<String, Object> map);

    void insertDepartment(Map<String, Object> map);

    void updateDepartment(Map<String, Object> map);

    void deleteDepartment(Map<String, Object> map);

}
