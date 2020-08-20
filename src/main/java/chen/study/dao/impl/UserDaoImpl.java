package chen.study.dao.impl;

import chen.study.dao.UserDao;
import chen.study.domain.QueryVo;
import chen.study.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用sqlsession中的方法实现查询列表
        List<User> users = sqlSession.selectList("chen.study.dao.UserDao.findAll");//参数就是能获取到配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
        return users;
    }

    public List<User> findAll1() {
        return null;
    }

    public void saveUser(User user) {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用方法实现保存
        sqlSession.insert("chen.study.dao.UserDao.saveUser",user);
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    public void updateUser(User user) {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用方法实现保存
        sqlSession.update("chen.study.dao.UserDao.updateUser",user);
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    public void deleteUser(int userId) {
    //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用方法实现保存
        sqlSession.delete("chen.study.dao.UserDao.deleteUser",userId);
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    public User findOne(Integer id) {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用sqlsession中的方法实现查询列表
        User users = sqlSession.selectOne("chen.study.dao.UserDao.findOne",id);//参数就是能获取到配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
        return users;
    }

    public List<User> findByName(String username) {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用sqlsession中的方法实现查询列表
        List<User> users = sqlSession.selectList("chen.study.dao.UserDao.findByName",username);//参数就是能获取到配置信息的key
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
        return users;
    }

    public int findTotal() {
        //1.根据factory获取sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.调用sqlsession中的方法实现查询列表
        Integer count= sqlSession.selectOne("chen.study.dao.UserDao.findTotal");//参数就是能获取到配置信息的key
        //4.释放资源
        sqlSession.close();
        return count;
    }

    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    public List<User> findByCondition(User user) {
        return null;
    }

    public List<User> findUserInIds(QueryVo vo) {
        return null;
    }
}
