package racing.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {
    @Test
    fun `race를 시작하면 반환되는 자동차 배열의 길이는 자동차 개수와 같다`() {
        val carNames = listOf("carA", "carB")
        val raceResult = Racing.start(carNames, 3)

        Assertions.assertThat(raceResult.size).isEqualTo(carNames.size)
    }
}
