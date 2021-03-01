package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingTest {

    @Test
    fun `자동차 이동 성공 하면 위치가 증가 한다`() {
        // given
        val cars = listOf<Car>(Car(), Car())
        val movable = object : Movable { override fun isMovable(): Boolean = true }
        val racing = Racing(cars, movable)

        // when
        racing.tryMove()

        // then
        assertThat(racing.positions).isEqualTo(listOf(1, 1))
    }
}
