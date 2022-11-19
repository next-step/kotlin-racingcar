package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `경주 게임은 입력값만큼의 자동차를 생성한다`() {
        // given
        val racingGame = RacingGame()

        // when
        racingGame.set(3, 5)

        // then
        assertThat(racingGame.carList.size).isEqualTo(3)
    }
}
