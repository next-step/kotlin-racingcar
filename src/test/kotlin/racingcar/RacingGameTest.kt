package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.RacingGame

class RacingGameTest {
    @CsvSource(
        value = [
            "'glen,glenn,win',3,4",
            "'glen,glenn,win',3,2",
        ]
    )
    @ParameterizedTest
    fun `주어진 횟수 동안 n대의 자동차는 전진 혹은 멈춰 있는다`(carNames: String, tryCnt: Int, condition: Int) {
        val racingGame = RacingGame(carNames, tryCnt)
        racingGame.execute { condition }
        assertThat(carNames.split(",").size).isEqualTo(racingGame.cars.size)
        assertThat(tryCnt).isEqualTo(racingGame.tryCnt)
    }
}
