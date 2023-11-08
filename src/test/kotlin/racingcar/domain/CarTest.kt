package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차 생성`() {
        val pobi = Car("pobi")
        val crong = Car("crong", 1)
        val honux = Car("honux", 3)

        assertEquals(Car("pobi", 0), pobi)
        assertEquals(Car("crong", 1), crong)
        assertEquals(Car("honux", 3), honux)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진한다`(input: Int) {
        val car = Car("pobi")
        car.move(input)
        assertEquals(car, Car("pobi", 1))
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `멈춘다`(input: Int) {
        val car = Car("pobi")
        car.move(input)
        assertEquals(car, Car("pobi", 0))
    }
}
