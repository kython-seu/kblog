package kblog.dao;

import kblog.entity.Blogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by kason_zhang on 4/20/2017.
 */
/**
 * 配置Spring与Junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BloggerDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private BloggerDao bloggerDao;

    @Test
    public void getByUsername() throws Exception {
        Blogger admin = bloggerDao.getByUsername("admin");
        logger.info("admin is {}",admin);
    }

    @Test
    public void getBloggerData() throws Exception {
        Blogger admin = bloggerDao.getBloggerData();
        logger.info("admin is {}",admin);
    }

    @Test
    public void updateBlogger() throws Exception {
        Blogger blogger = new Blogger();
        blogger.setNickname("sema");
        blogger.setPassword("asbc");
        blogger.setUserPhone(13567889021L);
        blogger.setUserEmail("sema@yaho.com");
        bloggerDao.updateBlogger(blogger);
    }

}