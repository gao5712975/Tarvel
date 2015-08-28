package com.tarvel.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuan on 2015/7/10 0010.
 */
public class Interceptor implements HandlerInterceptor {
    /**
     * preHandle()：这个方法在业务处理器处理请求之前被调用，在该方法中对用户请求request进行处理。
     * 如果程序员决定该拦截器对请求进行拦截处理后还要调用其他的拦截器，或者是业务处理器去进行处理，
     * 则返回true；如果程序员决定不需要再调用其他的组件去处理请求，则返回false。
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println(request);
        System.out.println(response);
        System.out.println(o);
        return false;
    }

    /**
     * postHandle()：这个方法在业务处理器处理完请求后，但是DispatcherServlet向客户端返回请求前被调用，在该方法中对用户请求request进行处理。
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(request);
        System.out.println(response);
        System.out.println(o);
    }

    /**
     * afterCompletion()：这个方法在DispatcherServlet完全处理完请求后被调用，可以在该方法中进行一些资源清理的操作。
     * @param request
     * @param response
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println(request);
        System.out.println(response);
        System.out.println(o);
    }
}
