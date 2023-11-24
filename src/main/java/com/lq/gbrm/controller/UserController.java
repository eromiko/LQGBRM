package com.lq.gbrm.controller;

import com.lq.gbrm.entity.User;
import com.lq.gbrm.entity.UserImg;
import com.lq.gbrm.service.UserService;
import com.lq.gbrm.util.BlobAndBase64Util;
import com.lq.gbrm.util.DataMapUtil;
import com.lq.gbrm.util.ExportWordUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/LQGBRM")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    ExportWordUtil exportWordUtil;

    @GetMapping("/HrPersonServlet")
    public void getUserInfo(String  personId,String  type, HttpServletResponse response){
        User user = userService.getUser(personId, type);
        Map dataMap;
        dataMap = DataMapUtil.setObjToMap(user);
        //导出表格
        String name =user.getName();
        String filename=name+"_干部任免审批表.doc";
        try {
            exportWordUtil.exportDoc(response,filename,"gbrmsp.ftl",dataMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/HrData")
    public String getUserInfo(String  personId){
        return "Hello";
    }
}
