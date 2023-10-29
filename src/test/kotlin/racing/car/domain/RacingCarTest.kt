package racing.car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarTest {

    @Test
    fun move() {
        val car = RacingCar()
        car.move(9)
        assertThat(car.position).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, false",
            "3, false",
            "4, true",
            "5, true",
        ],
        delimiter = ','
    )
    fun isMovable(input: Int, expected: Boolean) {
        val car = RacingCar()
        val actual = car.isMovable(input)
        assertThat(actual).isEqualTo(expected)
    }
}
