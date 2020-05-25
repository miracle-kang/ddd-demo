package com.miraclekang.clouddemo.infrastructure.domain;

import com.miraclekang.clouddemo.infrastructure.factory.BeanUtil;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collection;

public class DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    public DomainEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public static DomainEventPublisher instance() {
        return BeanUtil.getBean(DomainEventPublisher.class);
    }

    public <E> void publish(final E domainEvent) {
        this.publisher.publishEvent(domainEvent);
    }

    public <E> void publishAll(Collection<E> domainEvents) {
        domainEvents.forEach(this::publish);
    }
}
