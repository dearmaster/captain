package com.leaf.captain.blog.dao.impl;

import com.leaf.captain.blog.StartBlogApplication;
import com.leaf.captain.blog.dao.ArticleDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartBlogApplication.class)
@Transactional
public class ArticleDaoImplTest {

    @Autowired
    private ArticleDao articleDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void load() throws Exception {
        System.out.println(articleDao.load());
    }

}