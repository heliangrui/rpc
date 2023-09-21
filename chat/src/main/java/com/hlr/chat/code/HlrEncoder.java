package com.hlr.chat.code;

import com.hlr.chat.common.entity.HlrMsg;
import com.hlr.chat.common.enums.MsgType;
import com.hlr.chat.common.enums.RequestType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

/**
 * HlrEncoder
 * Description:
 * date: 2023/9/15 16:18
 *
 * @author hlr
 */
public class HlrEncoder extends MessageToByteEncoder<HlrMsg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, HlrMsg hlrMsg, ByteBuf byteBuf) throws Exception {
    
        byteBuf.writeInt(hlrMsg.getRequestType());
        byteBuf.writeInt(hlrMsg.getVersion());
        byteBuf.writeInt(hlrMsg.getAppId());
        byteBuf.writeInt(hlrMsg.getUserId());
        byteBuf.writeInt(hlrMsg.getVersion());
        byteBuf.writeInt(hlrMsg.getVersion());
        byteBuf.writeInt(hlrMsg.getVersion());
        byteBuf.writeInt(hlrMsg.getVersion());
        byteBuf.writeInt(hlrMsg.getVersion());
        
        if(byteBuf.readableBytes() < 36){
            return;
        }
        // 协议
        int requestType = byteBuf.readInt();
        if (RequestType.isRequestType(requestType)){
            channelHandlerContext.close();
            return;
        }
        HlrMsg msg = new HlrMsg();
        msg.setRequestType(requestType);
        // 版本号
        msg.setVersion(byteBuf.readInt());
        // 应用编号
        msg.setAppId(byteBuf.readInt());
        // 用户编号
        msg.setUserId(byteBuf.readInt());
        // 指令
        msg.setCommend(byteBuf.readInt());
        // 设备类型
        msg.setDeviceTypeLength( byteBuf.readInt());
        // 数据类型
        msg.setDataType(byteBuf.readInt());
        // 数据长度
        msg.setDataLength( byteBuf.readInt());

        // 数据类型是否支持

        if(msg.getDeviceTypeLength() > byteBuf.readableBytes() ){
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] deviceType = new byte[msg.getDeviceTypeLength()];
        byteBuf.readBytes(deviceType);
        msg.setDeviceType(new String(deviceType, StandardCharsets.UTF_8));
        if (msg.getDataLength() > byteBuf.readableBytes()){
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] data = new byte[msg.getDataLength()];
        byteBuf.writeBytes(data);

        MsgType msgType = MsgType.getRequestType(msg.getDataType());
        if(msgType != null){
            msg.setData(msgType.convert.convert(data));
        }
//        list.add(msg);

        byteBuf.markReaderIndex();
    }
}
