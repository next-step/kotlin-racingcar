package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarsTest {

    @Test
    fun `자동차들은 1대 이상 있어야 한다`() {
        assertThrows<IllegalArgumentException> { Cars.initialize(0, listOf("a", "b", "c"), FixedPowerGenerator(5)) }
    }

    @Test
    fun `자동차들은 특정 숫자 이상이 들어오면 움직인다`() {
        val cars = Cars.initialize(3, listOf("a", "b", "c"), FixedPowerGenerator(4))

        val result = cars.move()

        assertTrue(result.cars.all { it.position == 1 })
    }

    @Test
    fun `자동차들은 특정 숫자 미만이 들어오면 움직이지 않는다`() {
        val cars = Cars.initialize(3, listOf("a", "b", "c"), FixedPowerGenerator(3))

        val result = cars.move()

        assertTrue(result.cars.all { it.position == 0 })
    }
}
