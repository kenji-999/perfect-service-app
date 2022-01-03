package com.kibayashi.lessons.perfect.controller;

import com.kibayashi.lessons.perfect.dto.PerfectResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(PerfectController.ROOT)
@RestController
public class PerfectController {
    static final String ROOT = "/api/v1/perfect";
    static final String RESPONSE_MESSAGE = "Server is up and running. Returning a perfect response";

    @GetMapping
    public PerfectResponseDto getPerfectResponse() {
        return new PerfectResponseDto(RESPONSE_MESSAGE);
    }
}
