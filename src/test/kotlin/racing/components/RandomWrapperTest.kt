package racing.components

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomWrapperTest {

    @Test
    fun `nextInt test(real)`() {
        assertThat(RandomWrapperImpl().nextInt(10)).isBetween(0, 9)
    }

    @Test
    fun `test nextInt(if RandomWrapper is for test)`() {
        assertThat(RandomWrapperTestImpl(4).nextInt(10)).isEqualTo(4)
    }

    @Test
    fun `test nextInt(when RandomWrapper is for test and returnValue is not decided)`() {
        assertThat(RandomWrapperTestImpl().nextInt(10)).isEqualTo(9)
    }
}
