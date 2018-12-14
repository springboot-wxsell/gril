package com.ww.dao;

import com.ww.model.Gril;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WangWei
 * @Title: GrilRespository
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/8 17:26
 */
public interface GrilRespository extends JpaRepository<Gril, Integer> {

    // 通过姓名查询女生
    public List<Gril> findByAge(Integer  age);

}
