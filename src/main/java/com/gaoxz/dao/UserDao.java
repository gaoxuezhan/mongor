package com.gaoxz.dao;

import com.gaoxz.domain.UserEntity;

/**
 * Created by summer on 2017/5/5.
 */
public interface UserDao  {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public long updateUser(UserEntity user);

    public void deleteUserById(Long id);

}