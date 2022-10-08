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
    private Long seq;

    @UpdateColumn(updateFieldName = "greenCount")
    private Long count;

    @UpdateColumn(updateFieldName = "nickName")
    private String nickName;
}
