package com.ww.controller;

import com.ww.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangWei
 * @Title: HelloController
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/8 12:12
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private GrilProperties grilProperties;

    /*
    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/getCupSize")
    public String getCupSize(){
        return cupSize;
    }

    @RequestMapping(value = "/getContent")
    public String getContent() {
        return content;
    }
    */

    /*
    @RequestMapping(value = "/getGrilProperties")
    public String getGrilProperties() {
        return grilProperties.getCupSize();
    }

    @RequestMapping(value = "getIndex")
    public String getIndex(){
        return "index";
    }
    */
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "Hello Spring Boot!!!" + myId;
    }
}
