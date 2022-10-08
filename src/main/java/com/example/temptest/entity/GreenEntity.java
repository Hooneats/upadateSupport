package com.example.temptest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 그린랭킹 엔티티
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "green")
public class GreenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranking_seq", nullable = false)
    private Long rankingSeq;

    @Column(name = "nick_name", length = 50, nullable = false, unique = true)
    private String nickName;

    @Column(name = "green_count", nullable = false)
    private Long greenCount;

}
