package chen.study.test;

import chen.study.dao.AccountDao;
import chen.study.domain.Account;
import chen.study.domain.AccountUser;
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

public class AccountTest {
    private InputStream in;
    private SqlSessionFactoryBuilder sb;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao AccountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sb = new SqlSessionFactoryBuilder();
        factory = sb.build(in);
        sqlSession = factory.openSession(true);
        AccountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        in.close();
        sqlSession.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void findAllTest(){
        List<Account> account = AccountDao.findAll();
        for (Account account1 : account) {
            System.out.println("------------一个account的信息------------");
            System.out.println(account1);
            System.out.println(account1.getUser());
        }
    }

    /**
     * 测试查询所有账户，同时包含用户名称和地址
     */
    @Test
    public void findAllAccountTest(){
        List<AccountUser> allAccounts = AccountDao.findAllAccount();
        for (AccountUser allAccount : allAccounts) {
            System.out.println(allAccount);
        }
    }
}
