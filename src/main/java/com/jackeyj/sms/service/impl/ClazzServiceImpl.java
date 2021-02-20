package com.jackeyj.sms.service.impl;

import com.jackeyj.sms.dao.ClazzDao;
import com.jackeyj.sms.entity.ClazzEntity;
import com.jackeyj.sms.entity.vo.ClazzPojo;
import com.jackeyj.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<ClazzEntity> findAll(ClazzEntity clazzEntity) {
        return clazzDao.findAll(clazzEntity);
    }

    @Override
    public int insert(ClazzEntity clazzEntity) {
        return clazzDao.insert(clazzEntity);
    }

    @Override
    public int deleteById(Integer id) {
        return clazzDao.deleteById(id);
    }

    @Override
    public ClazzEntity selectById(Integer id) {
        return clazzDao.selectById(id);
    }

    @Override
    public int updateInfo(ClazzEntity clazzEntity) {
        return clazzDao.updateInfo(clazzEntity);
    }

    @Override
    public List<ClazzPojo> selectClazzNames() {
        return clazzDao.selectClazzNames();
    }

    @Override
    public List<ClazzEntity> filtrateClazz(String gradeName, String coordinator) {
        return clazzDao.filtrateClazz(gradeName, coordinator);
    }

    @Override
    public List<ClazzEntity> selectList() {
        return clazzDao.selectList();
    }
}
