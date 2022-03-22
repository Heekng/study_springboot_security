package com.heekng.security.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void createMember(String id, String password, String name, Authority authority) {
        this.loginId = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
}
