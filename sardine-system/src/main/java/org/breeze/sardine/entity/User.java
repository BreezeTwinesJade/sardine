package org.breeze.sardine.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.Data;

/**
 * @author huangyong
 */
@Data
@Table("user")
public class User {
  @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
  private Long userId;

  @Column(version = true)
  private Long version;

  @Column(isLogicDelete = true)
  private Boolean delete;
}
