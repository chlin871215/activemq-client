package com.example.activemqclient;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.Destination;

@SpringBootTest
class ActivemqClientApplicationTests {
    @Autowired
    private Client client;

    Destination destination = new ActiveMQQueue("request.queue");
    @Test
    void create() throws InterruptedException {
        String message = "{\"requestType\":\"create\",\"requestBody\":{\"cmNo\":\"1\",\"kacType\":\"2\",\"bankNo\":\"822\",\"ccy\":\"TWD\",\"bicaccNo\":\"1234\",\"acc\":[{\"accNo\":\"12\",\"amt\":10},{\"accNo\":\"13\",\"amt\":130}],\"ctName\":\"Berlin\",\"ctTel\":\"0955\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void getMgni() {
        String message = "{\"requestType\":\"getMgni\",\"requestBody\":{\"id\":\"\",\"bankNo\":\"\",\"ccy\":\"\",\"bicaccNo\":\"\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void getCashi() {
        String message = "{\"requestType\":\"getCashi\",\"requestBody\":{\"mgniId\":\"\",\"accNo\":\"\",\"ccy\":\"\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void updateMgni() {
        String message = "{\"requestType\":\"updateMgni\",\"requestBody\":{\"id\":\"MGI20221013163122508\",\"depositRequest\":{\"cmNo\":\"3\",\"kacType\":\"3\",\"bankNo\":\"822\",\"ccy\":\"TWD\",\"bicaccNo\":\"1234\",\"acc\":[{\"accNo\":\"12\",\"amt\":3000},{\"accNo\":\"13\",\"amt\":20000},{\"accNo\":\"13\",\"amt\":170}],\"ctName\":\"Berlin\",\"ctTel\":\"0955\"}}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void updateCashi() {
        String message = "{\"requestType\":\"updateCashi\",\"requestBody\":{\"mgniId\":\"MGI20221013163122508\",\"accNo\":\"12\",\"ccy\":\"TWD\",\"amt\":\"1000\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void deleteMgni() {
        String message = "{\"requestType\":\"deleteMgni\",\"requestBody\":{\"mgniId\":\"MGI20221013162752977\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }

    @Test
    void deleteCashi() {
        String message = "{\"requestType\":\"deleteCashi\",\"requestBody\":{\"mgniId\":\"MGI20221013162923140\",\"accNo\":\"12\",\"ccy\":\"TWD\"}}";
        System.out.println("request : " + message);
        client.sendMessage(destination, message);
    }




}
