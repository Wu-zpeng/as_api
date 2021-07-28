package com.example.as.api.service;

import com.example.as.api.mapper.UserMapper;
import com.example.as.api.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    @Autowired
    private UserMapper mUserMapper;
    public void addUser(String userName, String password, String imoocId, String orderId){
        mUserMapper.addUser(userName, password, imoocId, orderId, DateUtil.currentDate());
    }
}
