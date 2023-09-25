package com.hlr.core.network.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * serverSocket
 * Description:
 * date: 2023/9/25 17:29
 *
 * @author hlr
 */
public class serverSocket implements Runnable{
    @Override
    public void run() {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss,work).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            
                        }
                    });
            
        }catch (Exception e){
            
        }
        
        
    }
}
