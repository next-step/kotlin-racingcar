package racing.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racing.domain.movement.GoForwardMoveStrategy

internal class RacingCarsTest {
    @DisplayName("자동차를 전진시킨 경우 전진한 포지션의 리스트 반환")
    @Test
    fun race() {
        val racingCars = RacingCars.create(3)
        val expected = listOf(
            listOf(1, 1, 1),
            listOf(2, 2, 2),
            listOf(3, 3, 3),
        )

        val actual = racingCars.race(3, GoForwardMoveStrategy())

        assertThat(actual).isEqualTo(expected)
    }
}
