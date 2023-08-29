package com.hlr.chat.convert.protocol;

import com.hlr.chat.common.entity.HlrMsg;
import io.netty.channel.ChannelHandlerContext;

/**
 * ProtocolHandler
 * Description:
 * date: 2023/8/29 19:03
 *
 * @author hlr
 */
public interface ProtocolHandler {
    
    void protocol(ChannelHandlerContext channelHandlerContext, HlrMsg hlrMsg);
    
}
