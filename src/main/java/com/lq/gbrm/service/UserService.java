package com.lq.gbrm.service;

import com.lq.gbrm.entity.User;
import com.lq.gbrm.entity.UserImg;

import java.sql.Blob;
import java.util.List;

public interface UserService {

    User getUser(String personId, String type);

    UserImg getUserImg(String personId,User user);
}
