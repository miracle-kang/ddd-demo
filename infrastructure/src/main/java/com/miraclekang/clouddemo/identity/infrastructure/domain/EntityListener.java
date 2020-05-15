package com.miraclekang.clouddemo.identity.infrastructure.domain;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

public class EntityListener {

    private static final EntityListener INSTANCE = new EntityListener();

    private volatile AutowireCapableBeanFactory beanFactory;

    public static EntityListener get() {
        return INSTANCE;
    }

    public AutowireCapableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @PostLoad
    @PostPersist
    public void inject(Object object) {
        AutowireCapableBeanFactory beanFactory = get().getBeanFactory();
        if (beanFactory == null) {
            System.out.print(String.format("Bean Factory not set! Depdendencies will not be injected into: '{}'", object));
            return;
        }
        System.out.print(String.format("Injecting dependencies into entity: '{}'.", object));
        beanFactory.autowireBean(object);
    }

}
