package chen.study.test;

import chen.study.dao.RoleDao;
import chen.study.domain.Role;
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

public class RoleTest {
    private InputStream in;
    private SqlSessionFactoryBuilder sb;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sb = new SqlSessionFactoryBuilder();
        factory = sb.build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void Destroy() throws IOException {
        in.close();
        sqlSession.close();
    }

    /**
     * 测试RoleDao中的查询所有方法
     */
    @Test
    public void findAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("---------角色所对应的用户-----------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
