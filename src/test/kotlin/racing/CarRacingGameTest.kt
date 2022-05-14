package racing

import org.junit.jupiter.api.Test
import racing.model.CarInput
import racing.ui.ResultView

class CarRacingGameTest {
    @Test
    fun `레이싱 게임 테스트`() {
        val racingGame = CarRacingGame(CarInput(3, 5))
        val result = racingGame.start()
        ResultView(result, 5).printResult()
    }
}
