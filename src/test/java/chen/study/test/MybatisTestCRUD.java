package chen.study.test;

import chen.study.dao.UserDao;
import chen.study.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MybatisTestCRUD {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactoryBuilder sb;
    private SqlSessionFactory fa;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sb = new SqlSessionFactoryBuilder();
        fa = sb.build(in);
        sqlSession = fa.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException{
        //sqlSession.commit();
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
        user.setUsername("autoCommit");
        user.setAddress("陕西省西安市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.saveUser(user);

        System.out.println(user);
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
    public void findOneTest(){
        User one = userDao.findOne(51);
        System.out.println(one);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void findByNameTest(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * 测试查询总用户数
     */
    @Test
    public void findTotalTest(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public  void findByUserVoTest(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> userByVo = userDao.findUserByVo(vo);
        for (User user1 : userByVo) {
            System.out.println(user1);
        }
    }

    /**
     * 根据查询条件查询
     */
    @Test
    public void findByConditionTest(){
        User user = new User();
        user.setUsername("小小王");
        user.setSex("女");
        List<User> list = userDao.findByCondition(user);
        for (User users : list) {
            System.out.println(users);
        }
    }

    /**
     * 通过子查询测试foreach标签的使用
     */
    @Test
    public void findUserInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,48,52,53,54);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
