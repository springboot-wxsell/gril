package com.ww.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author WangWei
 * @Title: Gril
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/8 16:55
 */
@Entity
public class Gril {

    @Id
    @GeneratedValue
    private Integer id; // 主键id
    @NotBlank(message = "姓名不能为空!")
    private String name; // 姓名
    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age; // 年龄
    private String cupSize; // 罩杯

    public Gril() {
    }

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

    @Override
    public String toString() {
        return "Gril{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
