package com.zy.thread.future;

public class App {

    private static Data request(){
        FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData();
                futureData.setRealData(realData);
            }
        }).start();

        System.out.println("服务端已返回数据");

        return futureData;
    }

    public static void main(String[] args) throws InterruptedException {
        Data request = request();

        System.out.println("客户端已经接收到数据");

        System.out.println(request.getRequest());
    }
}
