package com.beini.mapper;

import com.beini.bean.UserInfo;
import com.beini.bean.UserListInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper {

    @Select("select * from UserInfo where username=#{userName} and password=#{password}")
    List<UserInfo> login(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert into userInfo(username,password) values(#{username},#{password});")
    int register(UserInfo userInfo);


    @Select("select * from UserInfo")
    List<UserListInfo> getUserList();


}
