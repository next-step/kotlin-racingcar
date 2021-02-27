package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingTest {

    @Test
    fun `test`() {
        // given
        val cars = arrayListOf<Car>(Car(), Car())
        val movable = object : Movable { override fun isMovable(): Boolean = true }
        val racing = Racing(cars, movable)

        // when
        racing.tryMove()

        // then
        assertThat(racing.positions).isEqualTo(arrayListOf(1, 1))
    }
}
