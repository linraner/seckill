package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        System.out.println(seckills);
    }

    @Test
    public void getById() throws Exception{
        long seckillId = 1000;
        Seckill seckill = seckillService.getById(seckillId);
        System.out.println(seckill);
    }

    @Test//完整逻辑代码测试 注意重复可执行
    public void exportSeckillUrl() {
        long seckillId = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            System.out.println(exposer);

            long userPhone = 12345678L;
            String md5 = exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
            } catch (RepeatKillException e) {
                e.printStackTrace();
            } catch (SeckillCloseException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println(exposer);
        }
    }

    @Test
    public void executeSeckill() {
        long seckillId=1000;
        String md5="bf204e2683e7452aa7db1a50b5713bae";
    }
}