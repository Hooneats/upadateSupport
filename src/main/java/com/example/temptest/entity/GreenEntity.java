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
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "green")
public class GreenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranking_seq")
    private Long rankingSeq;

//    @Column(name = "nick_name", length = 50, nullable = false, unique = true)
    @Column(name = "nick_name", length = 50)
    private String nickName;

    @Column(name = "green_count")
    private Long greenCount;

}
