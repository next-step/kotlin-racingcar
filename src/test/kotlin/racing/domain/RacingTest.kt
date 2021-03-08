package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingTest {

    @Test
    fun `레이스 후 결과를 조회 할수 있다`() {
        val cars = listOf(Car("a"), Car("b"))

        val racing = Racing(
            racingCars = RacingCars(cars = cars),
            movable = StaticMovable(true)
        )

        assertThat(racing.race(1)).isEqualTo(RacingResult(listOf(cars), cars))
    }
}
