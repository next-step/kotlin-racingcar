package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 대수만큼 자동차를 생성하는지 테스트`(input: Int) {
        val game = RacingCarGame(input, input + 1)
        game.play()

        val carSize = game.gameResult[0].size

        assertThat(carSize).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 시도횟수만큼 게임을 진행하는지 테스트`(input: Int) {
        val game = RacingCarGame(input + 1, input)
        game.play()

        val carSize = game.gameResult.size

        assertThat(carSize).isEqualTo(input)
    }
}