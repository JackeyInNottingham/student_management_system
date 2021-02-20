package com.jackeyj.sms.service;

import com.jackeyj.sms.common.bases.BaseService;
import com.jackeyj.sms.entity.GradeEntity;
import com.jackeyj.sms.entity.vo.GradePojo;

import java.util.List;

public interface GradeService extends BaseService<GradeEntity, GradeEntity> {
    List<GradePojo> selectGradeNames();

    List<GradeEntity> selectList();
}
