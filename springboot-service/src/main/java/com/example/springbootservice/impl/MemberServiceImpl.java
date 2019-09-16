package com.example.springbootservice.impl;

import com.example.springbootservice.annonation.Master;
import com.example.springbootservice.dto.Member;
import com.example.springbootservice.mapper.MemberMapper;
import com.example.springbootservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/26
 * Time  : 8:37 AM
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    @Transactional
    public int insert(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    @Master
    public int save(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    @Master
    public String getToken(String appId) {
        return null;
    }
}
