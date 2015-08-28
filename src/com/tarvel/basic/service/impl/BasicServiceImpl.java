package com.tarvel.basic.service.impl;

import com.tarvel.basic.exception.ConvertValueException;
import com.tarvel.basic.service.IBasicService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 基础Service接口实现
 * Created by Yuan on 2015/6/3.
 */
@Service("basicService")
public class BasicServiceImpl implements IBasicService {

    public <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties) {
        try {
            T t = target.newInstance();
            if (resource != null) {
                BeanUtils.copyProperties(resource, t, ignoreProperties);
            }
            return t;
        } catch (Exception e) {
            throw new ConvertValueException(e.getMessage(), e);
        }
    }

    public <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties) {
        if (resource != null) {
            BeanUtils.copyProperties(resource, target, ignoreProperties);
        }
        return (T) target;
    }
}
