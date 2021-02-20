package com.jackeyj.sms.common.bases;

import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.entity.vo.StudentVo;

import java.util.List;

/**
 * @author jiyaofei
 */
public interface BaseService<T, E> {

    /**
     * 查询所有信息
     * @param t
     * @return
     */
    List<T> findAll(T t);

    /**
     * 添加新记录
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    E selectById(Integer id);

    /**
     * 更新Vo信息
     * @param e
     * @return
     */
    int updateInfo(E e);

}
