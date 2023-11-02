package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1",
        ],
    )
    fun `car moves if random value is 4 or more`(randomValue: Int, expectedPosition: Int) {
        val car = Car()
        val movedCar = car.move(randomValue)
        assertThat(movedCar.position).isEqualTo(expectedPosition)
    }
}
