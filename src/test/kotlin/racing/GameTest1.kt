package racing

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingTest {

    @Test
    fun `자동차, Round 기준으로 2차원 Collection이 생성되는지 확인`() {
        val carCount = 2
        val roundCount = 1

        val racing = Racing(carCount = carCount, roundCount = roundCount)
        val result = racing.game(
            roundList = roundCount.toList(),
            carList = carCount.toList(),
        )

        assertThat(result.size).isEqualTo(roundCount)
        assertThat(result[0].size).isEqualTo(2)
    }


    @Test
    fun `랜덤으로 생성된 distance 가 4보다 작으면 0으로 생성된 Collection`() {
        val carCount = 2
        val roundCount = 1

        val random = mockk<RandomImpl>()
        every { random.getNumber() } returns 3

        val racing = Racing(carCount = carCount, roundCount = roundCount, distanceService = DistanceService(random))
        val result = racing.game(
            roundList = roundCount.toList(),
            carList = carCount.toList(),
        )

        assertThat(result[0][0].distance).isEqualTo(0)
        assertThat(result[0][1].distance).isEqualTo(0)
    }
}
