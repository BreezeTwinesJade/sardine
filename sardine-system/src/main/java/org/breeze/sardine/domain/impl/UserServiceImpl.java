package org.breeze.sardine.domain.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.breeze.sardine.domain.UserService;
import org.breeze.sardine.entity.User;
import org.breeze.sardine.repository.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author huangyong
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
