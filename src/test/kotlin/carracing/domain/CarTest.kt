package carracing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [5])
    fun `name - name of car cannot exceed UPPER_NAME_LENGTH characters`(upperNameLength: Int) {
        assertThrows<IllegalArgumentException> { Car("a".repeat(upperNameLength + 1)) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `move - if movingFactor is equal to or greater than 'MOVING_THRESHOLD', move once`(movingFactor: Int) {
        val car = Car(generateCarName())

        car.move(movingFactor)

        assertEquals(1, car.movingCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `move - if movingFactor is less than 'MOVING_THRESHOLD', do not move`(movingFactor: Int) {
        val car = Car(generateCarName())

        car.move(movingFactor)

        assertEquals(0, car.movingCount)
    }
}

fun generateCarName() = (1..5)
    .map { ('a'..'z').random() }
    .joinToString("")
