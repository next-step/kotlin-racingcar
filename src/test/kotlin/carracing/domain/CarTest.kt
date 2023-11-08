package carracing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `move - if movingFactor is equal to or greater than 4, move once`(movingFactor: Int) {
        val car = Car()

        car.move(movingFactor)

        assertEquals(1, car.movingCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `move - if movingFactor is less than 4, do not move`(movingFactor: Int) {
        val car = Car()

        car.move(movingFactor)

        assertEquals(0, car.movingCount)
    }
}
