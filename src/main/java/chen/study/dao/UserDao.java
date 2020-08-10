package chen.study.dao;

import chen.study.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    public List<User> findAll();

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
}
