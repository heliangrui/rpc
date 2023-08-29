package com.hlr.chat;

import com.hlr.chat.code.HlrDecoder;
import com.hlr.chat.handler.HandlerAdapter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyServer {  
    public static void main(String[] args) throws Exception {  
        EventLoopGroup bossGroup = new NioEventLoopGroup();  
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
        try {  
            ServerBootstrap bootstrap = new ServerBootstrap();  
            bootstrap.group(bossGroup, workerGroup)  
                    .channel(NioServerSocketChannel.class)  
                    .childHandler(new ChannelInitializer<Channel>() {  
                        @Override  
                        protected void initChannel(Channel ch) throws Exception {  
                            ch.pipeline().addLast(new HlrDecoder());
                            ch.pipeline().addLast(new HandlerAdapter());
                        }  
                    });  
  
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();  
            channelFuture.channel().closeFuture().sync();  
        } finally {  
            bossGroup.shutdownGracefully();  
            workerGroup.shutdownGracefully();  
        }  
    }  
  
    private static class WelcomeServerHandler extends ChannelInboundHandlerAdapter {  
        @Override  
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("欢迎访问服务器！\r\n");
        }  
        
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg){
            //获取客户端发送过来的消息
            System.out.println("收到客户端" + ctx.channel().remoteAddress() + "发送的消息：" + msg.toString());

        }
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //发送消息给客户端
            ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已收到消息，并给你发送一个问号?", CharsetUtil.UTF_8));
        }


        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            System.out.println("收到客户端" + ctx.channel().remoteAddress() + "关闭：");
        }
    }  
}