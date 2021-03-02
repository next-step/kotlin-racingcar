package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {
    private val car = Car()

    @Test
    fun `Car 는 move()하면 position 이 1 증가한다`() {
        assertThat(car.position).isEqualTo(0)

        car.move()

        assertThat(car.position).isEqualTo(1)
    }
}
