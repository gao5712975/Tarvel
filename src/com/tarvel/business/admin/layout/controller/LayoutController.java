package com.tarvel.business.admin.layout.controller;

import com.tarvel.shiro.session.ShiroSessionManage;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

/**
 * 主页
 * Created by Yuan on 2015/7/11 0011.
 */
@Controller
@RequestMapping("/")
public class LayoutController {
    private Logger logger = LoggerFactory.getLogger(LayoutController.class);

    @RequestMapping(value = "login")
    public String index(HttpServletRequest request) throws Exception {
        Object authExp = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (authExp != null) {
            if (Class.forName(authExp.toString()) == IncorrectCredentialsException.class) {
                logger.info("LOGIN_FAIL");
            }
            if (Class.forName(authExp.toString()) == AccountException.class) {
                logger.info("LOGIN_USERNAME_NOT_USE");
            }
            if (Class.forName(authExp.toString()) == AuthenticationException.class) {
                logger.info("SYSTEM_ERROR");
            }
            return "redirect:hello.do";
        }
        if (ShiroSessionManage.getLoginUser() != null) {
            return "redirect:index.do";
        }
        return "redirect:hello.do";
    }

    @RequestMapping(value = "hello")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
