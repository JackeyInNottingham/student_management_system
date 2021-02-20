package com.jackeyj.sms.service.impl;

import com.jackeyj.sms.dao.StudentDao;
import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.entity.vo.StudentVo;
import com.jackeyj.sms.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public StudentVo selectByUsernameAndPassword(String username, String password) {
        return studentDao.selectByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<StudentVo> selectList() {
        return studentDao.selectList();
    }

    @Override
    public String changePassword(Integer id, String oldPassword, String newPassword) {
        String password = studentDao.selectPasswordById(id);
        if (!oldPassword.equals(password)){
            return "原密码不匹配!";
        }
        int i = studentDao.updatePassword(id, newPassword);
        if (i > 0){
            return "success";
        }else {
            return "修改失败，该用户不存在!";
        }
    }

    @Override
    public String changePortrait(Integer id, String newPortraitPath) {
        int i = studentDao.changePortrait(id, newPortraitPath);
        if (i > 0){
            return "success";
        }else {
            return "更新失败";
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<StudentEntity> findAll(StudentEntity studentEntity) {
        return studentDao.findAll(studentEntity);
    }

    @Override
    public int insert(StudentEntity studentEntity) {
        return studentDao.insert(studentEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return studentDao.deleteById(id);
    }

    @Override
    public StudentVo selectById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public int updateInfo(StudentVo studentVo) {
        return studentDao.updateInfo(studentVo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<StudentVo> filtrateStudent(String studentName, String clazzName) {
        return studentDao.filtrateStudent(studentName, clazzName);
    }
}
