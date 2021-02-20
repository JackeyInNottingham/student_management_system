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
public class TeacherPojo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String name;

}
