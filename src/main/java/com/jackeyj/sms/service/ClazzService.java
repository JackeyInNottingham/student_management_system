package com.jackeyj.sms.service;

import com.jackeyj.sms.common.bases.BaseService;
import com.jackeyj.sms.entity.ClazzEntity;
import com.jackeyj.sms.entity.vo.ClazzPojo;

import java.util.List;

public interface ClazzService extends BaseService<ClazzEntity, ClazzEntity> {

    List<ClazzPojo> selectClazzNames();

    List<ClazzEntity> filtrateClazz(String gradeName, String coordinator);

    List<ClazzEntity> selectList();
}
