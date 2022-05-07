package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = ["3,true", "0,false", "3.3,false", "1,true", "-3,false"])
    fun `자연수인지 잘 판단하는지 테스트`(input: String, expect: Boolean) {
        val result = InputValidator.isNaturalNumber(input)
        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 대수만큼 자동차를 생성하는지 테스트`(input: Int) {
        val game = RacingCarGame(input, input + 1)
        game.prepare()
        game.play()

        val carSize = game.gameResult[0].size

        assertThat(carSize).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 시도횟수만큼 게임을 진행하는지 테스트`(input: Int) {
        val game = RacingCarGame(input + 1, input)
        game.prepare()
        game.play()

        val carSize = game.gameResult.size

        assertThat(carSize).isEqualTo(input)
    }
}