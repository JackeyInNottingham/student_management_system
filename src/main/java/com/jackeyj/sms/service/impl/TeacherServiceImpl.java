package com.jackeyj.sms.service.impl;

import com.jackeyj.sms.dao.TeacherDao;
import com.jackeyj.sms.entity.TeacherEntity;
import com.jackeyj.sms.entity.vo.TeacherPojo;
import com.jackeyj.sms.entity.vo.TeacherVo;
import com.jackeyj.sms.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TeacherVo selectByUsernameAndPassword(String username, String password) {
        return  teacherDao.selectByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TeacherVo> selectList() {
        return teacherDao.selectList();
    }

    @Override
    public String changePassword(Integer id, String oldPassword, String newPassword) {
        String password = teacherDao.selectPasswordById(id);
        if (!oldPassword.equals(password)){
            return "原密码不匹配!";
        }
        int i = teacherDao.updatePassword(id, newPassword);
        if (i > 0){
            return "success";
        }else {
            return "修改失败，该用户不存在!";
        }
    }

    @Override
    public String changePortrait(Integer id, String newPortraitPath) {
        int i = teacherDao.changePortrait(id, newPortraitPath);
        if (i > 0){
            return "success";
        }else {
            return "更新失败";
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TeacherEntity> findAll(TeacherEntity teacherEntity) {
        return teacherDao.findAll(teacherEntity);
    }

    @Override
    public int insert(TeacherEntity teacherEntity) {
        return teacherDao.insert(teacherEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return teacherDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TeacherVo selectById(Integer id) {
        return teacherDao.selectById(id);
    }

    @Override
    public int updateInfo(TeacherVo teacherVo) {
        return teacherDao.updateInfo(teacherVo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TeacherVo> filtrateTeacher(String teacherName, String clazzName) {
        return teacherDao.filtrateTeacher(teacherName, clazzName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TeacherPojo> selectTeacherNames() {
        return teacherDao.selectTeacherNames();
    }
}
