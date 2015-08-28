package com.tarvel.business.admin.layout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yuan on 2015/7/13 0013.
 */
@Controller
@RequestMapping("/")
public class UnauthorizedAction {
    @RequestMapping(value = "unauthorized")
    public ModelAndView unauthorized() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }
}
