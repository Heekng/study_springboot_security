package com.heekng.security.service;

import com.heekng.security.domain.Member;
import com.heekng.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getMemberId();
    }

    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원리스트
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원찾기
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
