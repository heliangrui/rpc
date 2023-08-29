package com.hlr.chat.convert.MsgData;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;

/**
 * MsgDataConvert
 * Description:
 * date: 2023/8/29 17:42
 *
 * @author hlr
 */
public class JsonObjectConvert implements Convert<JSONObject>{
    @Override
    public JSONObject convert(byte[] data) {
        return JSONObject.parseObject(new String(data, StandardCharsets.UTF_8));
    }
}
