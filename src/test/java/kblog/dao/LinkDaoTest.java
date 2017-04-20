package kblog.dao;

import kblog.entity.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by kason_zhang on 4/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LinkDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private LinkDao linkDao;

    @Test
    public void getLinkData() throws Exception {
        List<Link> linkData = linkDao.getLinkData();
        for(Link link : linkData){
            logger.info("link is \n{}",link);
        }
    }

    @Test
    public void listLinkData() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",0);
        map.put("pageSize",2);
        List<Link> links = linkDao.listLinkData(map);
        for(Link link : links){
            logger.info("link is \n{}",link);
        }
    }

    @Test
    public void getTotal() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",9);
        map.put("pageSize",2);
        Long total = linkDao.getTotal(map);
        logger.info("total is {}",total);
    }

    @Test
    public void addLink() throws Exception {

        Link link = new Link();
        link.setLinkname("game");
        link.setLinkurl("http://game.io/");
        Integer integer = linkDao.addLink(link);
        logger.info("insert integer : {}", integer);
    }

    @Test
    public void updateLink() throws Exception {

    }

    @Test
    public void deleteLink() throws Exception {

        Integer integer = linkDao.deleteLink(11);
        logger.info("delete succ : {}",integer);
    }

}