package racing

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DistanceServiceTest {

    private val random = mockk<RandomImpl>()
    private val distanceService = DistanceService(random)


    @Test
    fun `기준 4 보다 작은 경우 0 반환`() {
        every { random.getNumber() } returns 3
        assertThat(distanceService.get()).isEqualTo(0)
    }

    @Test
    fun `기준 4 보다 큰 경우 본 값 반환`() {
        every { random.getNumber() } returns 5
        assertThat(distanceService.get()).isEqualTo(5)
    }

}
