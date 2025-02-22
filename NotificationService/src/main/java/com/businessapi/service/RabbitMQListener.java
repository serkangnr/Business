package com.businessapi.service;

import com.businessapi.RabbitMQ.Model.RabbitMQNotification;
import com.businessapi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQListener {

    private final NotificationService notificationService;

    @Autowired
    public RabbitMQListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void listen(RabbitMQNotification rabbitMQNotification) {
        notificationService.createNotification(rabbitMQNotification.getUserId(), rabbitMQNotification.getMessage());
    }
}
