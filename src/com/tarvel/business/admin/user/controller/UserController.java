package com.tarvel.business.admin.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.tarvel.basic.page.Page;
import com.tarvel.business.admin.user.bo.User;
import com.tarvel.business.admin.user.po.UserEntity;
import com.tarvel.business.admin.user.service.UserService;
import com.tarvel.business.admin.user.vo.UserVO;
import com.tarvel.shiro.session.LoginUser;
import com.tarvel.shiro.session.ShiroSessionManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "findUserListView")
    public ModelAndView findUserListView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/user");
        return mv;
    }

    @RequestMapping(value = "findUserList")
    public void findUserList(@RequestParam("page") int nowpage, @RequestParam("rows") int rows, HttpServletResponse response) {
        User user = new User();
        Page<UserEntity> page = userService.findUserList(user, nowpage - 1, rows);
        JSONObject result = new JSONObject();
        result.put("rows", page.getResults());
        result.put("total", page.getTotal());
        try {
            PrintWriter writer = response.getWriter();
            writer.write(result.toString());
            log.debug(result.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "insertUser")
    public void insertUser(HttpServletResponse response, @ModelAttribute UserVO userVO) {
        try {
            PrintWriter writer = response.getWriter();
            LoginUser loginUser = ShiroSessionManage.getLoginUser();
            if (loginUser != null) {
                userVO.setCreateUser(loginUser.getUserId());
                userVO.setUpdateUser(loginUser.getUserId());
            }
            User user = userService.convertBusinessValue(userVO, User.class);
            userService.insertUser(user);
            JSONObject result = new JSONObject();
            result.put("result", "01");
            writer.write(result.toString());
            log.debug(result.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "updateUser")
    public void updateUser(HttpServletResponse response, @ModelAttribute UserVO userVO) {
        try {
            PrintWriter writer = response.getWriter();
            LoginUser loginUser = ShiroSessionManage.getLoginUser();
            User user = userService.convertBusinessValue(userVO, User.class);
            if (loginUser != null) {
                user.setUpdateUser(loginUser.getUserId());
            }
            userService.updateUser(user);
            JSONObject result = new JSONObject();
            result.put("result", "01");
            writer.write(result.toString());
            log.debug(result.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "deleteUser")
    public void deleteUser(HttpServletResponse response, @RequestParam("userId") String userId) {
        try {
            PrintWriter writer = response.getWriter();
            userService.deleteUser(userId);
            JSONObject result = new JSONObject();
            result.put("result", "01");
            writer.write(result.toString());
            log.debug(result.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
