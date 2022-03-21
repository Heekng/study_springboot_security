package com.heekng.security.domain;

import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column
    private Long memberId;

    private String id;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void createMember(String id, String password, String name, Authority authority) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
}
