package com.tarvel.bindingInitializer;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**日期的格式转换
 * Created by Yuan on 2015/7/14 0014.
 */
public class DateConverter implements WebBindingInitializer {
    public void initBinder(WebDataBinder binder, WebRequest request) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        } catch (Exception e) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
