package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {
    @Test
    fun `race를 시작하면 반환되는 2차 배열의 길이는 자동차 개수와 같다`() {
        val carNumber = 3
        val raceResult = Racing.start(carNumber, 3)

        Assertions.assertThat(raceResult.size).isEqualTo(carNumber)
    }

    @Test
    fun `race를 시작하면 반환되는 각 배열의 값은 0과 1을 포함한다`() {
        val carNumber = 3
        val raceResult = Racing.start(carNumber, 3)

        for (carResult in raceResult) {
            Assertions.assertThat(carResult).containsAnyOf(0, 1)
        }
    }
}
