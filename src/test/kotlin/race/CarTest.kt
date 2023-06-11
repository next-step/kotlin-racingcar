package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `기본 위치는 0`() {
        val condition = RandomMoveCondition()
        val car = Car(condition)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `한 번 이동하면 위치는 1`() {
        val condition = object : MoveCondition {
            override fun canGoStraight(): Boolean {
                return true
            }
        }

        val car = Car(condition)
        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
