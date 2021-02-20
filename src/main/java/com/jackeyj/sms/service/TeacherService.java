package com.jackeyj.sms.service;

import com.jackeyj.sms.common.bases.BaseService;
import com.jackeyj.sms.common.bases.UserService;
import com.jackeyj.sms.entity.TeacherEntity;
import com.jackeyj.sms.entity.vo.TeacherPojo;
import com.jackeyj.sms.entity.vo.TeacherVo;

import java.util.List;

public interface TeacherService extends BaseService<TeacherEntity, TeacherVo>, UserService<TeacherEntity, TeacherVo> {

    List<TeacherVo> filtrateTeacher(String teacherName, String clazzName);

    List<TeacherPojo> selectTeacherNames();
}
