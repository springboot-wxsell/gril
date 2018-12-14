package com.ww;

import com.ww.model.Gril;
import com.ww.service.GrilService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangWei
 * @Title: GrilServiceTest
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GrilServiceTest {

    @Autowired
    private GrilService grilService;

    @Test
    public void findOneTest(){
        Gril gril = grilService.findOne(4);
        Assert.assertEquals(new Integer(5), gril.getAge());
    }
}
