package com.jackeyj.sms.service;

import com.jackeyj.sms.common.bases.BaseService;
import com.jackeyj.sms.common.bases.UserService;
import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.entity.vo.StudentVo;

import java.util.List;

/**
 * @author jiyaofei
 */
public interface StudentService extends BaseService<StudentEntity, StudentVo>, UserService<StudentEntity, StudentVo> {

    /**
     * 筛选学生列表
     * @param studentName
     * @param clazzName
     * @return
     */
    List<StudentVo> filtrateStudent(String studentName, String clazzName);
}
