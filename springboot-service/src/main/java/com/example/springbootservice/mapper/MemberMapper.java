package com.example.springbootservice.mapper;


import com.example.springbootservice.dto.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/26
 * Time  : 8:39 AM
 */
public interface MemberMapper {
    int insert(@Param("member")Member member);
    List<Member> selectAll();
}
