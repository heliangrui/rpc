package com.hlr.chat.common.enums;

/**
 * RequestType
 * Description:
 * date: 2023/8/29 11:23
 *
 * @author hlr
 */
public enum RequestType {
    
    HlrRequestType(99999,"hlr自定义请求类型")
    ;
    public int type;
    public String name;
    
    
    RequestType(int type, String name){
        this.type = type;
        this.name = name;
    }
    
    public static RequestType getRequestType(int type){
        for (RequestType value : RequestType.values()) {
            if( value.type == type){
                return value;
            }
        }
        return null;
    }
    
    public static boolean isRequestType(int type){
        RequestType hlrRequestType = getRequestType(type);
        return hlrRequestType != null;
    }
    
    
    
    
}
