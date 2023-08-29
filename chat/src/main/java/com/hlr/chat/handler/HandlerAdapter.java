package com.hlr.chat.handler;

import com.hlr.chat.common.entity.HlrMsg;
import com.hlr.chat.common.enums.Protocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * HandlerAdapter
 * Description:
 * date: 2023/8/29 16:02
 *
 * @author hlr
 */
public class HandlerAdapter extends SimpleChannelInboundHandler<HlrMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HlrMsg hlrMsg) throws Exception {
        Protocol requestType = Protocol.getRequestType(hlrMsg.getCommend());
        if(requestType != null){
            requestType.protocolHandler.protocol(channelHandlerContext,hlrMsg);   
        }
        
    }
}
