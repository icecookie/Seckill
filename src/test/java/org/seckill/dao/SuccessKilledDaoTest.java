/**
 * 
 */
package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successkilledDao;
	/*我们重复执行insertSuccessKilled()讲道理程序应该报错，
	 * 因为我们同一个主键的数据在数据库中插入了两次，
	 * 但事实上并没有。
	 * 原因是：我们在SuccessKilledDao.xml中的插入语句中添加了ignore
	 * insert ignore into success_killed(seckill_id,user_phone,state)
	 * ingnored的作用就是避免主键冲突报错，如果主键存在不插入，如果主键不存在，则插入
	 * */
	@Test
    public void insertSuccessKilled() throws Exception 	{
		long id = 1001L;
		long phone = 18806529292L;
		int insertCount = successkilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount = " + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception 	{
    		long id = 1001L;
		long phone = 18806529292L;
		SuccessKilled successKilled = successkilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
    }
}
