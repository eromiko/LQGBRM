package com.lq.gbrm.mapper;

import com.lq.gbrm.entity.User;
import com.lq.gbrm.entity.UserImg;
import org.apache.ibatis.annotations.Select;

import java.sql.Blob;

public interface UserMapper {
    @Select("select ptm.fncell cell,p.FIDCardNO idcard,p.fname_l2 name,case when p.FGENDER=1 then '男' when p.FGENDER=2 then '女' end sex,to_char(p.fbirthday,'yyyyMM') birthday,t2.FName_L2 mz,t4.FName_l2 jk,\n" +
            "to_char(TRUNC(MONTHS_BETWEEN(SYSDATE, p.fbirthday) / 12)) age from t_bd_person p left join T_bd_hrhealth t4 on p.FHealthID=t4.FID left join T_BD_HRFolk t2 on p.FFolkID=t2.FID left join T_HR_PersonContactMethod ptm on ptm.fpersonid=p.fid\n" +
            "where p.fid=#{personId}")
    User getUser(String personId);
    @Select("select fimagedatasource Img from T_HR_PersonPhoto where fpersonid=#{personId}")
    UserImg getUserImg(String personId);
}
