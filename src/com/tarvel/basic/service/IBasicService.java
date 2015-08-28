package com.tarvel.basic.service;

/**
 * 基础Service层接口
 * Created by Yuan on 2015/6/16 0016.
 */
public interface IBasicService {

    /**
     * 转换业务对象
     *
     * @param resource
     * @param target
     * @return
     */
    <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties);

    /**
     * 转换业务对象
     *
     * @param resource
     * @param target
     * @return
     */
    <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties);

}
