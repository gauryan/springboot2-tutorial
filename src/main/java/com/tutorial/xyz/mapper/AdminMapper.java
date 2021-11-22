package com.tutorial.xyz.mapper;

import java.util.List;

import com.tutorial.xyz.dto.Admin;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Insert;
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

  // @Select("CALL SP_LIST_ADMIN()")
  // @Select("SELECT id, userid, password, nick FROM TB_ADMIN")
  List<Admin> listAdmin();

  // @Insert("CALL SP_INSERT_ADMIN(#{userid}, #{password}, #{nick})")
  int insertAdmin(@Param("userid") String userid, @Param("password") String password, @Param("nick") String nick);

  // @Select("SELECT id, userid, password, nick FROM TB_ADMIN WHERE id = #{id}")
  // @Select("CALL SP_GET_ADMIN(#{id})")
  Admin getAdmin(@Param("id") Long id);

  // @Update("CALL SP_UPDATE_ADMIN_PASSWORD(#{id}, #{password})")
  int updateAdminPassword(@Param("id") Long id, @Param("password") String password);
}
