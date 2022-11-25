package com.chenx.command.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SwaggerProperties
 * @Description Swagger属性配置
 * @Author daguniang
 * @Date 2022/11/12 19:32
 **/
@ConfigurationProperties(
        prefix = "custom.swagger"
)
public class SwaggerProperties {

    private Boolean enabled = false;

    private String[] basePackages;

    public String[] getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String[] basePackages) {
        this.basePackages = basePackages;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
