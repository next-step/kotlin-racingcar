package racingcarWinner.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcarWinner.util.MessageCode

internal class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["tester", "adbcde", "jessica"])
    fun `car does not have carName greater then 5`(carName: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(carName)
        }

        assertThat(exception.message).isEqualTo(MessageCode.CarNameMaxLengthException.message)
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `car does not have carName less then or equal 0`(carName: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(carName)
        }

        assertThat(exception.message).isEqualTo(MessageCode.CarNameMInLengthException.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, Int.MAX_VALUE])
    fun `move when randomNumber greater and equal then 4`(randomNumber: Int) {
        val carName = "test"
        val car = Car(carName)
        car.move(randomNumber)

        assertThat(car.moveStep).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 3, Int.MIN_VALUE])
    fun `no move when randomNumber less then 4`(randomNumber: Int) {
        val carName = "test"
        val car = Car(carName)
        car.move(randomNumber)

        assertThat(car.moveStep).isEqualTo(0)
    }

    @Test
    fun `isSameDistance should be true when distance equal to moveStep`() {
        val car = Car(carName = "test")
        val distance = 1
        car.move(6)

        val result = car.isSameDistance(distance)

        assertThat(result).isTrue
    }

    @Test
    fun `isSameDistance should be false when distance not equal to moveStep`() {
        val car = Car(carName = "test")
        val distance = 1
        car.move(3)

        val result = car.isSameDistance(distance)

        assertThat(result).isFalse
    }
}
