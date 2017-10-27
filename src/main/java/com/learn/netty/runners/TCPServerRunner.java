package com.learn.netty.runners;

import com.learn.netty.Services.DiscardServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author : mastXu
 * Description : saying something
 * Date : 2017/10/9.
 * Modify :
 */
@Component
public class TCPServerRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载 TCPSERVER<<<<<<<<<<<<<");
        System.out.println("args = " + strings.toString() );
        int port = 8920;
        new DiscardServer(port).run();
    }
}
