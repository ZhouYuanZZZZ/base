package com.zy.rabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        RPCClient rpcClient = new RPCClient();

        long start = System.currentTimeMillis();
        String result = rpcClient.call("xxxxdewfwrwer");
        long end = System.currentTimeMillis();
        System.out.println(result+":"+(end-start));

        rpcClient.close();
    }
}
