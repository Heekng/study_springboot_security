package com.heekng.security;

import com.heekng.security.domain.Authority;
import com.heekng.security.domain.Member;
import com.heekng.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitDb {
    private final MemberService memberService;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.createMember("heekng", "heekng1234", "고광", Authority.ROLE_ADMIN);
        memberService.join(member);
        log.info("create success!!");
    }
}
