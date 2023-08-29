package com.hlr.chat.common.enums;

import com.hlr.chat.common.entity.HlrMsg;
import com.hlr.chat.convert.MsgData.Convert;
import com.hlr.chat.convert.MsgData.JsonObjectConvert;
import com.hlr.chat.convert.protocol.LoginProtocol;
import com.hlr.chat.convert.protocol.ProtocolHandler;
import io.netty.channel.ChannelHandlerContext;

import java.util.function.Function;

/**
 * Protocol
 * Description:
 * date: 2023/8/29 19:07
 *
 * @author hlr
 */
public enum Protocol {


    Login(99999, new LoginProtocol())
    ;
    public final int type;
    public final ProtocolHandler protocolHandler;


    Protocol(int type, ProtocolHandler convert){
        this.type = type;
        this.protocolHandler = convert;
    }

    public static Protocol getRequestType(int type){
        for (Protocol value : Protocol.values()) {
            if( value.type == type){
                return value;
            }
        }
        return null;
    }



}
