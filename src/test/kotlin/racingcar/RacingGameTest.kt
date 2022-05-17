package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingGameTest {
    @CsvSource(value = ["3,3"])
    @ParameterizedTest
    fun `주어진 횟수 동안 n대의 자동차는 전진 혹은 멈춰 있는다`(carCnt: Int, tryCnt: Int) {
        val racingGame = RacingGame(carCnt, tryCnt)
        racingGame.execute()
        assertThat(carCnt).isEqualTo(racingGame.cars.size)
        assertThat(tryCnt).isEqualTo(racingGame.tryCnt)
    }
}
