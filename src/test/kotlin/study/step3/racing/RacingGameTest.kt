package study.step3.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.racing.RacingGame

internal class RacingGameTest {
    @Test
    fun `RacingGame에서는 Race 전체 결과를 반환한다`() {
        val generator = GeneratorStub()
        val racingGame = RacingGame(2, 2)

        assertThat(racingGame.run(generator)).isEqualTo(listOf(listOf(2, 2), listOf(3, 3)))
    }
}
