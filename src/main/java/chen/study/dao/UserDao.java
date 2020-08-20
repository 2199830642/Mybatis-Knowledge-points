package chen.study.dao;

import chen.study.domain.QueryVo;
import chen.study.domain.User;

import javax.management.Query;
import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作,同时获取到用户下所有账户的信息
     * @return
     */
    public List<User> findAll();

    /**
     * 查询所有用户及其所对应的角色信息
     * @return
     */
    public List<User> findAll1();

    /**
     * 保存方法
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新操作
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除操作
     */
    public void deleteUser(int userId);

    /**
     * 查询一个
     */
    public User findOne(Integer id);

    /**
     * 模糊查询，根据名称查
     */
    public List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    public int findTotal();

    /**
     * 根据QueryVo中的查询条件查询用户
     * @param vo
     * @return
     */
    public List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数查询
     * @param user 查询的条件，有可能有用户名，有可能有性别，也有可能有地址，还有可能是都有，也有可能都没有
     * @return
     */
    public List<User> findByCondition(User user);

    /**
     * 根据queryVo中提供的id集合查询用户信息
     * @param vo
     * @return
     */
    public List<User> findUserInIds(QueryVo vo);
}
