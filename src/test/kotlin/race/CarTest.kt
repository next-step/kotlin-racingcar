package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `기본 위치는 0`() {
        val condition = RandomMoveCondition()
        val car = Car("myCar", condition)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `한 번 이동하면 위치는 1`() {
        val condition = FixedMoveCondition(true)
        val car = Car("myCar", condition)
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            val condition = FixedMoveCondition(true)
            Car("myNewCar", condition)
        }
    }
}
