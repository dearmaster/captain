package com.leaf.captain.dear.dao.impl;

import com.leaf.captain.dear.Application;
import com.leaf.captain.dear.dao.BlogDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class BlogDaoImplTest {

    @Autowired
    private BlogDao blogDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void load() throws Exception {
        System.out.println(blogDao.load());
    }

}