package com.zy.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TestRabbitMq {

    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;

    @Before
    public void setUp() throws IOException, TimeoutException {
         factory = new ConnectionFactory();
         factory.setHost("192.168.1.142");
         factory.setPort(5672);
         factory.setUsername("zy");
         factory.setPassword("zy");
         connection = factory.newConnection();
         channel = connection.createChannel();
    }

    @After
    public void close() throws IOException, TimeoutException {
       // connection.close();
       // channel.close();
    }

    @Test
    public void test0() throws IOException, InterruptedException {
        channel.queueDeclare("Q2", true, false, false, null);
        String message = "";
        //Thread.sleep(2000);
        for (int i = 0; i <10 ; i++) {
            message=i+"";
            int prefetchCount = 1;
            channel.basicQos(prefetchCount);
            channel.basicPublish("","Q1",  MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        }
        System.out.println(" [x] Sent '" + message + "'");
    }

    @Test
    public void test1() throws IOException, TimeoutException {
        String message = "zzzz";
        channel.exchangeDeclare("EX1", "fanout");

        for (int i = 0; i <10 ; i++) {
            channel.basicPublish("EX1", "", null, message.getBytes());
        }

        System.out.println("ok");

    }
}
