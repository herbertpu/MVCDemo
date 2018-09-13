package com.login.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * 封装客户端提交的表单数据到formBean中
 * 把request对象中的请求参数封装到bean中
 */
public class WebUtils {

    /**
     * 将request对象转换成T对象
     * @param request
     * @param cla
     * @param <T>
     * @return
     */
    public static <T> T requestBean(HttpServletRequest request, Class<T> cla){
        try {
            //1.创建要封装数据的bean
            T bean = cla.newInstance();
            //2.把request中的数据整到bean中
            Enumeration<String> enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()){
                String name = enumeration.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyBean(Object form, Object user) {
        // 注册日期转换器
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                if(value == null) {
                    return null;
                }


                String str = (String) value;
                if(str.trim().equals("")) {
                    return null;
                }

                // 1980-09-32
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return (Object) df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }

        }, Date.class);

        try {
            /**
             * 在此项目中，是从formBean将属性拷贝到user对象中去，bean的拷贝
             * 在实际开发中，非常实用
             */
            BeanUtils.copyProperties(user, form);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成UUID
     * @return
     */
    public static String makeId(){
        return UUID.randomUUID().toString();
    }
}
