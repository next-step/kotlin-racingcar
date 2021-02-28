package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarTest {

    @Test
    fun `차 전진`() {
        val car = Car()
        assertEquals(car.getProgress(), 0)

        car.moveForward()
        assertEquals(car.getProgress(), 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9, 10])
    fun `차가 움직일때`(randomNumber: Int) {
        val car = Car()
        assertThat(car.checkPossibleToMove(randomNumber)).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `차가 움직이지 않을때`(randomNumber: Int) {
        val car = Car()
        assertThat(car.checkPossibleToMove(randomNumber)).isEqualTo(true)
    }
}
