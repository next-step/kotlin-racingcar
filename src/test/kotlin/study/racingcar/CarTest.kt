package study.racingcar

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
            "6, 1"
        ]
    )
    fun `car moves if random value is 4 or more`(randomValue: Int, expectedPosition: Int) {
        val car = Car("hong")
        val movedCar = car.move(randomValue)
        assertThat(movedCar.position).isEqualTo(expectedPosition)
    }

    @Test
    fun `car name cannot exceed 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
        assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters")
    }
}
