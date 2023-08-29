package com.hlr.chat.common.enums;

import com.hlr.chat.convert.MsgData.Convert;
import com.hlr.chat.convert.MsgData.JsonObjectConvert;

/**
 * MegType
 * Description:
 * date: 2023/8/29 17:43
 *
 * @author hlr
 */
public enum MsgType {


    JsonObjectType(99999,new JsonObjectConvert())
    ;
    public int type;
    public Convert convert;


    MsgType(int type, Convert convert){
        this.type = type;
        this.convert = convert;
    }

    public static MsgType getRequestType(int type){
        for (MsgType value : MsgType.values()) {
            if( value.type == type){
                return value;
            }
        }
        return null;
    }


    
}
