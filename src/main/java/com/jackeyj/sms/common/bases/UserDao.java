package com.jackeyj.sms.common.bases;

import java.util.List;

/**
 * @author jiyaofei
 */
public interface UserDao<T, E> {

    /**
     * 登陆时进行验证
     * @param username
     * @param password
     * @return
     */
    E selectByUsernameAndPassword(String username, String password);

    /**
     * 查询所有可展示信息 *Vo
     * @return
     */
    List<E> selectList();

    /**
     * 根据id查询密码
     * @param id
     * @return
     */
    String selectPasswordById(Integer id);

    /**
     * 修改密码
     * @param id
     * @param newPassword
     * @return
     */
    int updatePassword(Integer id, String newPassword);

    /**
     * 更新头像
     * @param id
     * @param newPortraitPath
     * @return
     */
    int changePortrait(Integer id, String newPortraitPath);
}
