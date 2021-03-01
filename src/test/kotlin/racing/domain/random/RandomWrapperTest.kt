package racing.domain.random

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomWrapperTest {

    @Test
    fun `nextInt test(real)`() {
        assertThat(DefaultRandomWrapper().nextInt(10)).isBetween(0, 9)
    }

    @Test
    fun `test nextInt(if RandomWrapper is for test)`() {
        assertThat(TestRandomWrapper(4).nextInt(10)).isEqualTo(4)
    }
}
