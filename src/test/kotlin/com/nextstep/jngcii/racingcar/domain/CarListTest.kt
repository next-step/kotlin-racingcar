package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarListTest {

    @ParameterizedTest
    @CsvSource(
        "A:10|B:20|C:30, C",
        "A:30|B:20|C:30, A:C",
        "A:10|B:10|C:10, A:B:C"
    )
    fun `winners 확인 테스트`(carStrings: String, expectedStrings: String) {

        val cars = carStrings.split(PIPE_DELIMITER).map {
            val (name, distance) = it.split(COLON_DELIMITER)
            return@map PrefixCar(name = name, distance = distance.toInt())
        }

        val expected = expectedStrings.split(COLON_DELIMITER)

        Assertions.assertThat(cars.winners.map { it.name }).isEqualTo(expected)
    }

    companion object {
        private const val PIPE_DELIMITER = "|"
        private const val COLON_DELIMITER = ":"
    }

    private class PrefixCar(
        name: String,
        override val distance: Int
    ) : Car(name)
}
