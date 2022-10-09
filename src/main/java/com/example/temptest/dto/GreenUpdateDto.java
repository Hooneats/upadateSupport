package com.example.temptest.dto;

import com.example.temptest.support.UpdateColumn;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GreenUpdateDto {

    @UpdateColumn(name = "rankingSeq")
    private Long seq;

    @UpdateColumn(name = "greenCount")
    private Long count;

    @UpdateColumn(name = "nickName")
    private String nickName;
}
