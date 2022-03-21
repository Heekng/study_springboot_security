package com.heekng.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column
    private Long member_id;

    private String id;
    private String password;

}
