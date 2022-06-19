package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RacingCarGameTest {

    @Test
    fun `4대의 자동차를 만든다`() {
        // given
        val expectedSize = 4

        // when
        val resultCars = RacingCarGame().generateCars(4)

        // then
        Assertions.assertThat(resultCars.size).isEqualTo(expectedSize)
    }

    @Test
    fun `0과 9 사이의 중 하나의 숫자를 임의로 생성한다`() {
        // when
        val rangeList = (0..9)
        val testNumber = RacingCarGame().generateRandomNumber()

        // then
        Assertions.assertThat(rangeList).contains(testNumber)
    }
}
