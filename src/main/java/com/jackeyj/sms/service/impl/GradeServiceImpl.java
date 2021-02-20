package com.jackeyj.sms.service.impl;

import com.jackeyj.sms.dao.GradeDao;
import com.jackeyj.sms.entity.GradeEntity;
import com.jackeyj.sms.entity.vo.GradePojo;
import com.jackeyj.sms.service.GradeService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<GradeEntity> findAll(GradeEntity gradeEntity) {
        return gradeDao.findAll(gradeEntity);
    }

    @Override
    public int insert(GradeEntity gradeEntity) {
        return gradeDao.insert(gradeEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return gradeDao.deleteById(id);
    }

    @Override
    public GradeEntity selectById(Integer id) {
        return gradeDao.selectById(id);
    }

    @Override
    public int updateInfo(GradeEntity gradeEntity) {
        return gradeDao.updateInfo(gradeEntity);
    }

    @Override
    public List<GradePojo> selectGradeNames() {
        return gradeDao.selectGradeNames();
    }

    @Override
    public List<GradeEntity> selectList() {
        return gradeDao.selectList();
    }
}
