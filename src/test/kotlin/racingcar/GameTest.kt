package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest {
    @ParameterizedTest
    @CsvSource(
        "1,0",
        "4,0",
        "5,1",
        "9,1"
    )
    fun `자동차 이동 테스트`(input: Int, result: Int) {
        val racingCar = RacingCar("a").apply {
            this.move(input)
        }
        assertThat(racingCar.carDistance).isEqualTo(result)
    }
}
