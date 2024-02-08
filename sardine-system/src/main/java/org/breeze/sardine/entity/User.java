package org.breeze.sardine.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.io.Serializable;
import java.sql.Timestamp;

import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * 用户表 实体类。
 *
 * @author huangyong
 * @since 2024-02-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user")
public class User {

  /**
   * id
   */
  @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
  private Long userId;

  /**
   * 用户编码
   */
  private String userCode;

  /**
   * 用户名称
   */
  private String username;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 手机号
   */
  private String phoneNumber;

  /**
   * 最后登录时间
   */
  private Timestamp lastLoginTime;

  /**
   * 最后登录ip
   */
  private Timestamp lastLoginIp;

  /**
   * 创建时间
   */
  private Timestamp createTime;

  /**
   * 创建人id
   */
  private Long createUserId;

  /**
   * 创建人名称
   */
  private String createUsername;

  /**
   * 最后修改时间
   */
  private Timestamp lastModifyTime;

  /**
   * 最后修改人id
   */
  private Long lastModifyUserId;

  /**
   * 最后修改人名称
   */
  private String lastModifyUsername;

  /**
   * 是否删除
   */
  @Column(isLogicDelete = true)
  private Boolean deleted;

  /**
   * 版本号
   */
  @Column(version = true)
  private Long version;

}
