package carracing

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class CarTest {

    @Test
    fun `test car has an initial position of zero`() {
        val car = Car(name = "pobi")
        
        assertEquals(expected = 0, actual = car.position)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `test car does not move forward`(num: Int) {
        val car = Car(name = "pobi")
        car.move(random = num)
        assertEquals(expected = 0, actual = car.position)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `test car moves forward`(num: Int) {
        val car = Car(name = "pobi")
        car.move(random = num)
        assertEquals(expected = 1, actual = car.position)
    }
    @Test
    fun `test when car name length is greater than 5 should throw exception with appropriate message`() {

        val exception = assertFailsWith<IllegalArgumentException> {
            val car = Car(name = "pobizzz")
            car.move(random = 2)
        }
        assertEquals("Name cannot exceed 5 characters", exception.message)
    }
}
