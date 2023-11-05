package study.racingcar.domain

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @Test
    fun `car name cannot exceed 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
        assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters")
    }

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
        val car = Car("test")
        val movedCar = car.move(randomValue)
        assertThat(movedCar.position).isEqualTo(expectedPosition)
    }

    @Test
    fun `car with higher position should win`() {
        val leadingCar = Car(name = "Fast", position = 10)
        val followingCar = Car(name = "Slow", position = 5)

        val result = leadingCar.isWin(followingCar)

        assertThat(result).isTrue
    }

    @Test
    fun `car with lower position should not win`() {
        val leadingCar = Car(name = "Fast", position = 15)
        val followingCar = Car(name = "Slow", position = 10)

        val result = followingCar.isWin(leadingCar)

        assertThat(result).isFalse
    }

    @Test
    fun `car with same position should not win`() {
        val car1 = Car(name = "Car1", position = 10)
        val car2 = Car(name = "Car2", position = 10)

        val result = car1.isWin(car2)
        val result2 = car2.isWin(car1)

        assertThat(result).isFalse
        assertThat(result2).isFalse
    }
}
