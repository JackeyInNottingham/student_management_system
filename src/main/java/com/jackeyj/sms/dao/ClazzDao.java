package com.jackeyj.sms.dao;

import com.jackeyj.sms.entity.ClazzEntity;
import com.jackeyj.sms.common.bases.BaseDao;
import com.jackeyj.sms.entity.vo.ClazzPojo;
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
public interface ClazzDao extends BaseDao<ClazzEntity, ClazzEntity> {

    List<ClazzPojo> selectClazzNames();

    List<ClazzEntity> filtrateClazz(String gradeName, String coordinator);

    List<ClazzEntity> selectList();
}
