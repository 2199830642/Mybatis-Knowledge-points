package chen.study.dao;

import chen.study.domain.Account;
import chen.study.domain.AccountUser;

import java.util.List;

public interface AccountDao{
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 查询所有账户，同时还有获取该账户所属的用户名称及地址信息
     * @return
     */
    public List<AccountUser> findAllAccount();

    /**
     * 根据用户信息uid查询账户信息
     * @param uid
     * @return
     */
    public List<Account> findAccountByUid(Integer uid);
}
