package com.racing.step4.domain

import com.racing.step3.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {
    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "2, 0",
        "3, 0",
        "4, 1",
        "5, 1",
        "6, 1",
        "7, 1",
        "9, 1"
    )
    fun `자동차는 4 이상의 숫자가 들어와야 한 칸 전진한다`(input: Int, answer: Int) {
        // given
        var car = Car("$input")
        // when
        car = car.move { input }

        // then
        assertThat(car.position).isEqualTo(answer)
    }
}
