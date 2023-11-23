package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차 생성`() {
        val moveStrategy: () -> Int = { 1 }

        val pobi = Car("pobi", moveStrategy)
        val crong = Car("crong", moveStrategy, 1)
        val honux = Car("honux", moveStrategy, 3)

        assertEquals(Car("pobi", moveStrategy, 0), pobi)
        assertEquals(Car("crong", moveStrategy, 1), crong)
        assertEquals(Car("honux", moveStrategy, 3), honux)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진한다`(input: Int) {
        val moveStrategy: () -> Int = { input }
        val car = Car("pobi", moveStrategy)
        car.move()
        assertEquals(car, Car("pobi", moveStrategy, 1))
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `멈춘다`(input: Int) {
        val moveStrategy: () -> Int = { input }
        val car = Car("pobi", moveStrategy)
        car.move()
        assertEquals(car, Car("pobi", moveStrategy, 0))
    }
}
