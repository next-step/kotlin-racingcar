package com.racing.step3.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.Random

class CarTest {
    @ParameterizedTest
    @CsvSource(
        "4, 1",
        "5, 1",
        "6, 1",
        "7, 1",
        "8, 1",
        "9, 1"
    )
    fun `랜덤으로 4 이상의 값이 입력되면 position이 증가`(input: Int, answer: Int) {
        // given
        var car = Car()
        // when
        car = car.move { input }

        // then
        Assertions.assertThat(car.position).isEqualTo(answer)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "2, 0",
        "3, 0",
        "0, 0"
    )
    fun `랜덤으로 4 미만의 값이 입력되면 position이 증가`(input: Int, answer: Int) {
        // given
        val car = Car()
        // when
        car.move { input }

        // then
        Assertions.assertThat(car.position).isEqualTo(answer)
    }

    @RepeatedTest(30)
    fun `랜덤 변수 생성 테스트`() {
        // given
        val limit = 10

        // when
        val result = Random().nextInt(10)

        // then
        Assertions.assertThat(result).isLessThan(10)
        println(result)
    }
}
