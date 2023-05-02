package com.example.histo.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HellowResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){

        String name = "test";
        int amount = 1000;

        HellowResponseDto hellowResponseDto = new HellowResponseDto(name, amount);

        assertThat(hellowResponseDto.getName()).isEqualTo(name);
        assertThat(hellowResponseDto.getAmount()).isEqualTo(amount);

    }
}
