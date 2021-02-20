package com.jackeyj.sms.service.impl;

import com.jackeyj.sms.dao.AdminDao;
import com.jackeyj.sms.entity.AdminEntity;
import com.jackeyj.sms.entity.vo.AdminVo;
import com.jackeyj.sms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jiyaofei
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public AdminVo selectByUsernameAndPassword(String username, String password) {
        return adminDao.selectByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AdminVo> selectList() {
        return adminDao.selectList();
    }

    @Override
    public String changePassword(Integer id, String oldPassword, String newPassword) {
        String password = adminDao.selectPasswordById(id);
        if (!oldPassword.equals(password)){
            return "原密码不匹配!";
        }
        int i = adminDao.updatePassword(id, newPassword);
        if (i > 0){
            return "success";
        }else {
            return "修改失败，该用户不存在!";
        }
    }

    @Override
    public String changePortrait(Integer id, String newPortraitPath) {
        int i = adminDao.changePortrait(id, newPortraitPath);
        if (i > 0){
            return "success";
        }else {
            return "更新失败";
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AdminEntity> findAll(AdminEntity adminEntity) {
        return adminDao.findAll(adminEntity);
    }

    @Override
    public int insert(AdminEntity adminEntity) {
        return adminDao.insert(adminEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return adminDao.deleteById(id);
    }

    @Override
    public AdminVo selectById(Integer id) {
        return adminDao.selectById(id);
    }

    @Override
    public int updateInfo(AdminVo adminVo) {
        return adminDao.updateInfo(adminVo);
    }
}
