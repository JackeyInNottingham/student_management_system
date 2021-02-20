package com.jackeyj.sms.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 
 * 
 * @author yaofei
 * @email yaofei_ji@126.com
 * @date 2020-12-12 00:06:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class ClazzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer number;
	/**
	 * 
	 */
	private String introduction;
	/**
	 * 
	 */
	private String coordinator;
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
	private String gradeName;

}
