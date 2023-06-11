package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `기본 위치는 0`() {
        val car = Car()
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `한 번 이동한 경우 위치는 0(후진) 또는 1(직진)`() {
        val car = Car()
        car.move()
        assertThat(car.position).isIn(0, 1)
    }
}
