package com.jackeyj.sms.dao;

import com.jackeyj.sms.common.bases.UserDao;
import com.jackeyj.sms.entity.TeacherEntity;
import com.jackeyj.sms.common.bases.BaseDao;
import com.jackeyj.sms.entity.vo.TeacherPojo;
import com.jackeyj.sms.entity.vo.TeacherVo;
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
public interface TeacherDao extends BaseDao<TeacherEntity, TeacherVo>, UserDao<TeacherEntity, TeacherVo> {

    List<TeacherVo> filtrateTeacher(String teacherName, String clazzName);

    List<TeacherPojo> selectTeacherNames();
}
