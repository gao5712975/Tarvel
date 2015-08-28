package com.tarvel.shiro.authz;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 扩展Roles验证方式，匹配任何一个所属角色就通过
 * @author liujiegang
 */
public class MyRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request,
            ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = getSubject(request, response);
        String rolesArray[] = (String[]) mappedValue;
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        } else {
            List roles = CollectionUtils.asList(rolesArray);
            boolean[] checks = subject.hasRoles(roles);
            for (boolean c : checks) {
                if(c) return true;
            }
            return false;
        }
    }
    
    public Map<String, Object> getAppliedPaths() {
        return this.appliedPaths;
    }
}
