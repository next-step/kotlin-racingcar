package com.racing.step4.domain

import com.racing.step3.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {
    @ParameterizedTest
    @CsvSource(
        "goofy, 1, 0",
        "goofy, 2, 0",
        "goofy, 3, 0",
        "goofy, 0, 0",
        "goofy, 4, 1",
        "goofy, 5, 1",
        "goofy, 6, 1",
        "goofy, 7, 1",
        "goofy, 8, 1",
        "goofy, 9, 1"
    )
    fun `4(trigger) 기준으로 자동차가 움직이는지 테스트`(name: String, input: Int, answer: Int) {
        // given
        var car = Car()
        // when
        car = car.move { input }

        // then
        assertThat(car.position).isEqualTo(answer)
    }

    @Test
    fun `자동차가 움직인 이후 toString() 동작 확인`() {
        // given
        val name = "goofy"
        var car = Car(name)

        // when
        car = car.move { 5 }

        // then
        assertThat(car.position).isEqualTo(1)
        assertThat(car.toString()).isEqualTo(name + " : -\n")
    }
}
