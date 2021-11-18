package com.tutorial.xyz.mapper;

import java.util.List;

import com.tutorial.xyz.model.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

  @Select("CALL LIST_ADMIN()")
  // @Select("SELECT id, userid, password, nick FROM TB_ADMIN")
  List<Admin> listAdmin();
}
