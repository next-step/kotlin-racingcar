package racing

import org.junit.jupiter.api.Test
import racing.ui.ResultView

class RacingCarTest {
    @Test
    fun `레이싱 게임 테스트`() {
        val result = CarRacingGame(4, 5).start()
        ResultView(result, 5).printResult()
    }
}
