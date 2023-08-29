package com.hlr.chat.convert.MsgData;

/**
 * Convert
 * Description:
 * date: 2023/8/29 17:48
 *
 * @author hlr
 */
public interface Convert<T> {
    
    public T convert(byte[] data);
    
}
