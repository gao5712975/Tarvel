package com.tarvel.business.admin.department.service;

import java.util.List;
import java.util.Map;

/**机构服务接口
 * Created by Yuan on 2015/7/3 0003.
 */
public interface DepartmentService {

    List<Map<String,Object>> findDepartmentChildren(Map<String, Object> map);

    List<Map<String,Object>> findDepartmentParent(Map<String, Object> map);

    String insertDepartment(Map<String, Object> map);

    void updateDepartment(Map<String, Object> map);

    void deleteDepartment(Map<String, Object> map);
}
