package com.jackeyj.sms.dao;

import com.jackeyj.sms.common.bases.BaseDao;
import com.jackeyj.sms.common.bases.UserDao;
import com.jackeyj.sms.entity.AdminEntity;
import com.jackeyj.sms.entity.vo.AdminVo;
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
public interface AdminDao extends BaseDao<AdminEntity, AdminVo>, UserDao<AdminEntity, AdminVo> {

}
