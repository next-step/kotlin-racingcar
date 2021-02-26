package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    internal fun `레이싱게임 객체를 플레이수와 함께 생성한다`() {
        RacingGame(5, 3)
    }

    @Test
    internal fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(5, 3)
        racingGame.play()
        assertThat(racingGame.positions().size).isEqualTo(5)
        for (positions in racingGame.positions()) {
            assertThat(positions).contains(Position(5), Position(5), Position(5))
        }
    }

    @Test
    internal fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(5, 3)
        racingGame.play()
        assertThat(racingGame.positions.size).isEqualTo(3)
        for (position in racingGame.positions) {
            assertThat(position).isEqualTo(Position(5))
        }
    }
}
