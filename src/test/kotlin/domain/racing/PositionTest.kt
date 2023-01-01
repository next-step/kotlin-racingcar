package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `위치가 이동된다`() {
        val position = Position.create()

        assertThat(position.move().position).isEqualTo(1)
    }
}
