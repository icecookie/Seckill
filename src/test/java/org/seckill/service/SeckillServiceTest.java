package org.seckill.service;

import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={ }", list);
	}

	@Test
	public void testGetById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}", seckill);
	}
	/*
	@Test
	public void testExportSeckillUrl() throws Exception {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
	}

	@Test
	public void testExecuteSeckill() throws Exception {
		long id = 1000;
		long phone = 18806529292L;
		String md5 = "0fab3da527c0249cfc72a6e0141bdfd5";
		try {
			SeckillExecution exception = seckillService.executeSeckill(id, phone, md5);
			logger.info("result={}",exception);
		} catch (RepeatKillException e) {
			logger.error(e.getMessage());
		}catch (SeckillCloseException e) {
			logger.error(e.getMessage());
		}
	}
	 */
	//测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogic() throws Exception {
		long id = 1001;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()) {
			String md5 = exposer.getMd5();
			long phone = 18806529292L;
			try {
				SeckillExecution exception = seckillService.executeSeckill(id, phone, md5);
				logger.info("result={}",exception);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			}catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		} else {
			//秒杀未开启
			logger.warn("exposer={}", exposer);
		}
	}
}
