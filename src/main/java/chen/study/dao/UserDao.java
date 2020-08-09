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
}
