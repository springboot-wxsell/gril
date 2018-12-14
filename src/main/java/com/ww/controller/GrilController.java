package com.ww.controller;

import com.ww.exception.GrilException;
import com.ww.model.Gril;
import com.ww.dao.GrilRespository;
import com.ww.model.Result;
import com.ww.service.GrilService;
import com.ww.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author WangWei
 * @Title: GrilController
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/8 17:21
 */
@RestController
@RequestMapping("/gril")
public class GrilController {

    private final static Logger log = LoggerFactory.getLogger(GrilController.class);
    @Autowired
    private GrilRespository grilRespository;

    @Autowired
    private GrilService grilService;

    /**
     * 查询所有的女生列表
     * @return
     */
    @GetMapping(value = "/grils")
    public List<Gril> grilList() {
       log.info("grilList 方法执行了！");
        return grilRespository.findAll();
    }

    /**
     * 添加一个女生
     * @param gril
     * @return
     */
    @PostMapping(value = "/grils")
    public Result<Gril> grilSave(@Valid Gril gril, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtils.fail( 0, bindingResult.getFieldError().getDefaultMessage());
        }
        gril.setName(gril.getName());
        gril.setAge(gril.getAge());
        gril.setCupSize(gril.getCupSize());
        return ResultUtils.success(grilRespository.save(gril));
    }

    /**
     * 根据id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/grils/{id}")
    public Gril grilGetOne(@PathVariable("id") Integer id) {
        Gril girl = new Gril();
        girl.setId(id);
        return grilRespository.findById(id).get();
    }

    /**
     * 根据id修改女生
     * @param id
     * @param name
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/grils/{id}")
    public Gril grilUpdateById(@PathVariable("id") Integer id, @RequestParam("name") String name,
                               @RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize){
        Gril gril = new Gril();
        gril.setId(id);
        gril.setName(name);
        gril.setAge(age);
        gril.setCupSize(cupSize);
        return grilRespository.save(gril);
    }

    /**
     * 根据id删除女生
     * @param id
     */
    @DeleteMapping(value = "/grils/{id}")
    public void grilDeleteById(@PathVariable("id") Integer id) {
        grilRespository.deleteById(id);
    }

    /**
     * 根据姓名查找女生列表
     * @param age
     * @return
     */
    @GetMapping(value = "/grils/age/{age}")
    public List<Gril> grilFindByAge(@PathVariable("age") Integer age) {
        return grilRespository.findByAge(age);
    }

    @GetMapping(value = "/grils/getAge/{id}")
    public void  getAge(@PathVariable("id") Integer id) throws Exception {
        grilService.getAge(id);
    }

}
