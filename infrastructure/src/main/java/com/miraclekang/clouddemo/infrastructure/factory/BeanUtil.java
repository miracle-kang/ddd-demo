package com.miraclekang.clouddemo.infrastructure.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Get bean from Spring IoC Container
 *
 * @author kangliqi
 */
@Component
public class BeanUtil {

    private static BeanUtil instance;

    private final ApplicationContext applicationContext;

    @Autowired
    public BeanUtil(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        instance = this;
    }

    /**
     * 通过Bean名称从Spring IoC容器中获取一个Bean
     *
     * @param name bean名称
     * @return
     */
    public static Object getBean(String name) {
        return instance.applicationContext.getBean(name);
    }

    /**
     * 通过Bean类型从Spring IoC容器中获取一个Bean
     *
     * @param clazz bean类型
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return instance.applicationContext.getBean(clazz);
    }

    /**
     * 通过指定的名称和类型从Spring IoC容器中获取一个Bean
     *
     * @param name  bean名称
     * @param clazz bean类型
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return instance.applicationContext.getBean(name, clazz);
    }
}
