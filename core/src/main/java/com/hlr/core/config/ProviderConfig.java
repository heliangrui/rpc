package com.hlr.core.config;

/**
 * ProviderConfig
 * Description:
 * date: 2023/9/21 10:37
 *
 * @author hlr
 */
public class ProviderConfig {
    
    private String nozzle; // 接口
    private String ref; //映射
    private String alias; // 别名
    private String version; // 版本

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
