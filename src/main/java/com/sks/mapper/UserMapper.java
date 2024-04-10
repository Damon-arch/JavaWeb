package com.sks.mapper;

import com.sks.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUser(int id);

    String getPasswordByName(@Param("name") String name);
}
