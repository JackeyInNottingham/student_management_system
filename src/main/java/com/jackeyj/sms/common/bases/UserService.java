package com.jackeyj.sms.common.bases;

import java.util.List;

/**
 * @author jiyaofei
 */
public interface UserService<T, E> {

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    E selectByUsernameAndPassword(String username, String password);

    /**
     * 查找可展示信息 *Vo
     * @return
     */
    List<E> selectList();

    /**
     * 修改密码
     * @param id
     * @param newPassword
     * @param oldPassword
     * @return
     */
    String changePassword(Integer id, String oldPassword, String newPassword);

    String changePortrait(Integer id, String newPortraitPath);
}
