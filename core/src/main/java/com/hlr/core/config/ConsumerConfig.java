package com.hlr.core.config;

/**
 * ConsumerConfig
 * Description:
 * date: 2023/9/21 10:28
 *
 * @author hlr
 */
public class ConsumerConfig<T> {
    
    private String nozzle; // 接口
    
    private String alias; // 别名
    
    private String version; // 版本

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
