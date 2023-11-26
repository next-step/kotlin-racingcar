package carracing

import carracing.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGameTest {

    @Test
    fun `랜덤 게임 테스트`() {
        val name = "car"
        val cars = listOf(Car(name))
        cars.map { it.move() }
        assertThat(cars.first().position).isIn(0, 1)
        assertThat(cars.first().name).isEqualTo(name)
    }
}
