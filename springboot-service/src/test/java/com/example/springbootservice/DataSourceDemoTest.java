package com.example.springbootservice;

import com.example.springbootservice.dto.Member;
import com.example.springbootservice.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/6/29
 * Time  : 3:49 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@MapperScan("com.example.springbootservice.mapper")
public class DataSourceDemoTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setAge(23);
        member.setName("zhou");
        memberService.insert(member);
    }
}
