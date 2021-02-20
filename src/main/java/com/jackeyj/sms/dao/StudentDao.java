package com.jackeyj.sms.dao;

import com.jackeyj.sms.common.bases.UserDao;
import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.common.bases.BaseDao;
import com.jackeyj.sms.entity.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author yaofei
 * @email yaofei_ji@126.com
 * @date 2020-12-12 00:06:11
 */
@Repository
public interface StudentDao extends BaseDao<StudentEntity, StudentVo>, UserDao<StudentEntity, StudentVo> {

    /**
     * 筛选学生
     *
     * @param studentName
     * @param clazzName
     * @return
     */
    List<StudentVo> filtrateStudent(String studentName, String clazzName);
}