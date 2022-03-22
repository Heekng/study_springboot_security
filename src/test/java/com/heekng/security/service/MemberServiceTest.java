package com.heekng.security.service;

import com.heekng.security.domain.Authority;
import com.heekng.security.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.createMember("heekng2", "heekng1234", "고광2", Authority.ADMIN);

        //when
        Long memberId = memberService.join(member);

        //then
        assertEquals(member, memberService.findOne(memberId));
    }
}