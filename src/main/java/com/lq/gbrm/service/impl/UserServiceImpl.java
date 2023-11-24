package com.lq.gbrm.service.impl;

import com.lq.gbrm.entity.User;
import com.lq.gbrm.entity.UserImg;
import com.lq.gbrm.mapper.UserMapper;
import com.lq.gbrm.service.UserService;
import com.lq.gbrm.util.BlobAndBase64Util;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl<blob> implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public User getUser(String personId, String type) {
        //获得手机号、身份证、姓名、年龄、出生日期、性别
        User user = userMapper.getUser(personId);
        user.setBirthday(user.getBirthday() + "<w:br />（"
                + user.getAge() + "岁）");
        UserImg userImg = getUserImg(personId, user);
        //照片
        String StringUserImg = BlobAndBase64Util.getBase64InBlob(userImg.getImg());
        user.setImg(StringUserImg);
        //返回数据
        return user;
    }

    @Override
    public UserImg getUserImg(String personId,User user) {
        return userMapper.getUserImg(personId);
    }
}
