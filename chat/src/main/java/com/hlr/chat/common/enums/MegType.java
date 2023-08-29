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
public enum MegType {


    JsonObjectType(99999,new JsonObjectConvert())
    ;
    public int type;
    public Convert convert;


    MegType(int type, Convert convert){
        this.type = type;
        this.convert = convert;
    }

    public static MegType getRequestType(int type){
        for (MegType value : MegType.values()) {
            if( value.type == type){
                return value;
            }
        }
        return null;
    }


    
}
