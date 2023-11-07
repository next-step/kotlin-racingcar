package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진한다`(input: Int) {
        val car = Car()
        car.move(input)
        assertEquals(car, Car(1))
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `멈춘다`(input: Int) {
        val car = Car()
        car.move(input)
        assertEquals(car, Car(0))
    }
}
