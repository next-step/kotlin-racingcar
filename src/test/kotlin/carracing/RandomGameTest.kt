package carracing

import carracing.dto.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGameTest {

    @Test
    fun `랜덤 게임 테스트`() {
        val name = "carName"
        val cars = listOf(Car(name))
        RandomGame().execute(cars)
        assertThat(cars.first().position).isIn(0, 1)
        assertThat(cars.first().name).isEqualTo(name)
    }
}
