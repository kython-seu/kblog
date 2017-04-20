package kblog.dao;

import kblog.entity.Blog;
import kblog.entity.BlogType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class BlogDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BlogDao blogDao;
    @Test
    public void getBlogData() throws Exception {

        List<Blog> blogData = blogDao.getBlogData();

        for(Blog blog : blogData){
            logger.info("blog: {}",blog);
        }

        /**
         * 2017-04-20 15:20:52,556 [main] INFO  kblog.dao.BlogDaoTest - blog:
         * Blog{id=35, title='demo', summary='test', releaseDate=Thu Apr 20 15:16:21 CST 2017,
         * clickHit=1, replyHit=2, content='11111', keyWord='null', contentNoTag='null', blogType=null, blogCount=1,
         * releaseDateStr='2017年04月', imageList=[]}
         2017-04-20 15:20:52,557 [main] INFO  kblog.dao.BlogDaoTest - blog:
         Blog{id=36, title='demo2', summary='demo', releaseDate=Mon Mar 20 15:16:31 CST 2017,
         clickHit=12, replyHit=34, content='呵呵呵大', keyWord='null', contentNoTag='null', blogType=null, blogCount=1,
         releaseDateStr='2017年03月', imageList=[]}
         */
    }

    @Test
    public void listBlog() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("pageSize", 2);
        map.put("typeId", null);
        map.put("releaseDateStr", null);
        List<Blog> blogs = blogDao.listBlog(map);
        for(Blog blog : blogs){
            logger.info("blog {}",blog);
        }
        /**
         * 2017-04-20 15:34:45,739 [main] INFO  kblog.dao.BlogDaoTest - blog
         * Blog{id=36, title='demo2', summary='demo', releaseDate=Mon Mar 20 15:16:31
         * CST 2017, clickHit=12, replyHit=34, content='呵呵呵大', keyWord='null',
         * contentNoTag='null', blogType=null, blogCount=null, releaseDateStr='null',
         * imageList=[]}
         */
    }

    @Test
    public void getTotal() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("pageSize", 2);
        map.put("typeId", null);
        map.put("releaseDateStr", null);
        long num = blogDao.getTotal(map);

        logger.info("num {}",num);

    }

    @Test
    public void findById() throws Exception {

        Blog byId = blogDao.findById(36);

        logger.info("blogbyId : {}",byId);
    }

    @Test
    public void update() throws Exception {
        Blog blog = new Blog();
        blog.setContent("你们好，你们都是帮帮的");
        blog.setId(35);
        BlogType blogType = new BlogType();
        blogType.setId(null);
        blog.setBlogType(blogType);
        blogDao.update(blog);
    }

    @Test
    public void getPrevBlog() throws Exception {

        int id = 36;
        Blog prevBlog = blogDao.getPrevBlog(id);
        logger.info("pre blog :\n{}",prevBlog);
    }

    @Test
    public void getNextBlog() throws Exception {
        int id = 35;
        Blog nextBlog = blogDao.getNextBlog(id);
        logger.info("next blog :\n {} ",nextBlog);
    }

    @Test
    public void addBlog() throws Exception {

        BlogType blogType = new BlogType();
        blogType.setId(16);
        Blog blog = new Blog("Hadoop","Hadoop Study"
        ,new Date(),0,0,"Hadoop学习指南","Hadoop",blogType);
        Integer integer = blogDao.addBlog(blog);
        logger.info("sate : {}",integer);

    }

    @Test
    public void deleteBlog() throws Exception {

    }

    @Test
    public void getBlogByTypeId() throws Exception {

    }

}