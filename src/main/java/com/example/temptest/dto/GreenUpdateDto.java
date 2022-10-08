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

    @UpdateColumn(updateFieldName = "rankingSeq")
    private Long rankingSeq;

    @UpdateColumn(updateFieldName = "greenCount")
    private Long greenCount;

    @UpdateColumn(updateFieldName = "nickName")
    private String nickName;
}
