package com.hlr.chat.common.entity;

/**
 * HlrMsg
 * Description:
 * date: 2023/8/29 11:08
 *
 * @author hlr
 */
public class HlrMsg {
    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommend() {
        return commend;
    }

    public void setCommend(int commend) {
        this.commend = commend;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }
    

    public int getDeviceTypeLength() {
        return deviceTypeLength;
    }

    public void setDeviceTypeLength(int deviceTypeLength) {
        this.deviceTypeLength = deviceTypeLength;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getDataType() {
        return dataType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    // 协议  
    // 版本号
    // 应用编号
    // 用户编号
    // 指令
    // 数据长度
    // 数据
    private int requestType;
    
    private int version;
    
    private int appId;
    
    private int userId;
    
    private int commend;
    
    private int deviceTypeLength;
    
    private int dataType;

    private int dataLength;
    
    private String deviceType;
    
    
    private Object data;
    
    
}
