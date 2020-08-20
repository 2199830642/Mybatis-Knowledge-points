package chen.study.test;

import chen.study.dao.UserDao;
import chen.study.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest1 {
    private InputStream in;
    private SqlSessionFactoryBuilder sb;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private chen.study.dao.UserDao UserDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sb = new SqlSessionFactoryBuilder();
        factory = sb.build(in);
        sqlSession = factory.openSession(true);
        UserDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        in.close();
        sqlSession.close();
    }

    /**
     * 测试查询所有用户及其所对应的角色信息   多对多
     */
    @Test
    public void findAllTest(){
        List<User> users = UserDao.findAll1();
        for (User user : users) {
            System.out.println("------------一个user的信息------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
