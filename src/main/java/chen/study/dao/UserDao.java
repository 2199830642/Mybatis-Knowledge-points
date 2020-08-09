package chen.study.dao;

import chen.study.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
