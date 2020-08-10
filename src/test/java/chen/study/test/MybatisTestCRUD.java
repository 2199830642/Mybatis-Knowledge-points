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
import java.util.Date;
import java.util.List;

public class MybatisTestCRUD {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sb = new SqlSessionFactoryBuilder();
        SqlSessionFactory fa = sb.build(in);
        sqlSession = fa.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException{
        sqlSession.commit();
        in.close();
        sqlSession.close();
    }
    /**
     * 查询所有
     */
    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void saveTest(){
        User user = new User();
        user.setUsername("小陈");
        user.setAddress("陕西省西安市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }
    /**
     * 测试更新操作
     */
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(48);
        user.setUsername("小王");
        user.setAddress("陕西省渭南市");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }
    /**
     * 测试删除操作
     */
    @Test
    public void deleteTest(){
        userDao.deleteUser(46);
    }

    /**
     * 测试查询一个
     */
    @Test
    public void findOne(){
        User one = userDao.findOne(51);
        System.out.println(one);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }

    }
}
