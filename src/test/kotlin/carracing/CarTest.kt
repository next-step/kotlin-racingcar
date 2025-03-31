package carracing

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertEquals

class CarTest {

    @Test
    fun `test car has an initial position of zero`() {
        val car = Car(name = "Car 1")

        assertEquals(expected = 0, actual = car.position)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `test car does not move forward`(num: Int) {
        val car = Car(name = "Car 1")
        car.move(random = num)
        assertEquals(expected = 0, actual = car.position)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `test car moves forward`(num: Int) {
        val car = Car(name = "Car 1")
        car.move(random = num)
        assertEquals(expected = 1, actual = car.position)
    }
}
