package racing

import io.mockk.every
import io.mockk.mockkObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DistanceTest {

    @BeforeEach
    fun setup() {
        mockkObject(Distance)
    }

    @Test
    fun `기준 4 보다 작은 경우 0 반환`() {
        every { Distance.getRandom() } returns 3
        assertThat(Distance.get()).isEqualTo(0)
    }

    @Test
    fun `기준 4 보다 큰 경우 본 값 반환`() {
        every { Distance.getRandom() } returns 5
        assertThat(Distance.get()).isEqualTo(5)
    }

}
