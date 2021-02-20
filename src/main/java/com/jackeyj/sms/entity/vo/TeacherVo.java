package com.jackeyj.sms.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author jiyaofei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class TeacherVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String tno;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String gender;
    /**
     *
     */
    private String email;
    /**
     *
     */
    private String telephone;
    /**
     *
     */
    private String address;
    /**
     *
     */
    private String portraitPath;
    /**
     *
     */
    private String clazzName;

}
