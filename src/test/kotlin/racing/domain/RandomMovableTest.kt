package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomMovableTest {

    @Test
    fun `threshold이상 일경우 isMovable 하다`() {
        assertThat(RandomMovable(max = 9, threshold = 0).isMovable()).isEqualTo(true)
        assertThat(RandomMovable(max = 9, threshold = 10).isMovable()).isEqualTo(false)
    }
}
