package com.ww.service;

import com.ww.dao.GrilRespository;
import com.ww.enums.ResultEnum;
import com.ww.exception.GrilException;
import com.ww.model.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author WangWei
 * @Title: GrilService
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 14:59
 */
@Service
public class GrilService {

    @Autowired
    private GrilRespository grilRespository;

    /**
     * 根据id查询女生的年龄
     * @param id
     * @throws Exception
     */
    public void getAge(Integer  id) throws Exception {
        Integer age = grilRespository.findById(id).get().getAge();
        if (age > 0 && age < 10) {
            throw new GrilException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            throw new GrilException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 根据id查询一个女生信息
     * @param id
     * @return
     */
    public Gril findOne(Integer id) {
        return  grilRespository.findById(id).get();
    }
}
