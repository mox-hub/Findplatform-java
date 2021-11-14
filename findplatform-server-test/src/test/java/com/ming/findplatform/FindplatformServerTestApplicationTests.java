package com.ming.findplatform;

import com.ming.findplatform.mapper.UserMapper;
import com.ming.findplatform.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class FindplatformServerTestApplicationTests {

    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() throws Exception{
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
    }


}
