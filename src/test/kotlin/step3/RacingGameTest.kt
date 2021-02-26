package step3

import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    internal fun `레이싱게임 객체를 플레이수와 함께 생성한다`() {
        RacingGame(5)
    }

    class RacingGame(private val playCount: Int)
}
