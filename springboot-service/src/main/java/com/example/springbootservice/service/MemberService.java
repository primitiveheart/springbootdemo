package com.example.springbootservice.service;

import com.example.springbootservice.dto.Member;

import java.util.List;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/26
 * Time  : 8:35 AM
 */
public interface MemberService {
    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);
}
