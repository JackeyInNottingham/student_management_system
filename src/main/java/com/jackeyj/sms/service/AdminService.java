package com.jackeyj.sms.service;

import com.jackeyj.sms.common.bases.BaseService;
import com.jackeyj.sms.common.bases.UserService;
import com.jackeyj.sms.entity.AdminEntity;
import com.jackeyj.sms.entity.vo.AdminVo;
import org.springframework.stereotype.Service;

/**
 * @author jiyaofei
 */
@Service
public interface AdminService extends BaseService<AdminEntity, AdminVo>, UserService<AdminEntity, AdminVo> {


}
