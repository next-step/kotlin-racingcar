package car.racing

import car.racing.domain.Car
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `Move 테스트`(condition: Int) {
        val car = Car(1)

        val response = car.move(0, condition)

        assertEquals("-", response)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `Stop 테스트`(condition: Int) {
        val car = Car(1)

        val response = car.move(0, condition)

        assertEquals("", response)
    }
}
