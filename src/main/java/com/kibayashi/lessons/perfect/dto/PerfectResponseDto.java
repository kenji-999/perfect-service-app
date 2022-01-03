package com.kibayashi.lessons.perfect.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(onConstructor_ = {@JsonCreator})
public class PerfectResponseDto {
    private final String message;
}
