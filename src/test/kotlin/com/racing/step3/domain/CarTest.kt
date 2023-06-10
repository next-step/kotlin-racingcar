package com.racing.step3.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "2, 0",
        "3, 0",
        "0, 0",
        "4, 1",
        "5, 1",
        "6, 1",
        "7, 1",
        "8, 1",
        "9, 1"
    )
    fun `4 라는 숫자를 기준으로 자동차가 움직이는지 테스트`(input: Int, answer: Int) {
        // given
        var car = Car()
        // when
        car = car.move { input }

        // then
        Assertions.assertThat(car.position).isEqualTo(answer)
    }
}
