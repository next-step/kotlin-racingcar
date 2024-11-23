package misson.car

import misson.car.domain.CarPositionFormatter
import misson.car.domain.RacingCar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarPositionFormatterTest {
    @Test
    fun `자동차 위치마다 -를 , 앞에 자동차 이름을 붙인다`() {
        val car = RacingCar("car1", 3)
        val result = CarPositionFormatter.formatCarPosition(car)

        assertThat(result).isEqualTo("자동차 car1 : ---")
    }

    @ParameterizedTest
    @CsvSource(
        "0, ''",
        "1, '-'",
        "3, '---'",
        "5, '-----'",
    )
    fun `position마다 -를 붙인다`(
        position: Int,
        expected: String,
    ) {
        val result = CarPositionFormatter.formatPosition(position)

        assertThat(result).isEqualTo(expected)
    }
}
