package com.ww.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WangWei
 * @Title: GrilProperties
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/8 15:06
 */
@Component
@ConfigurationProperties(prefix = "gril")
public class GrilProperties {

    private Integer id; // 主键id
    private String name; // 姓名
    private Integer age; // 年龄
    private String cupSize; // 罩杯

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
