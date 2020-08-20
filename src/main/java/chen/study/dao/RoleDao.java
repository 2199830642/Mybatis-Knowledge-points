package chen.study.dao;

import chen.study.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll();
}
