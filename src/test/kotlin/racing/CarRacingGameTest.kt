package racing

import org.junit.jupiter.api.Test
import racing.model.CarInput
import racing.ui.ResultView

class CarRacingGameTest {
    @Test
    fun `레이싱 게임 테스트`() {
        val racingGame = CarRacingGame(CarInput(listOf("pobi","crong","honux"), 5))
        val result = racingGame.start()
        ResultView(result).printResult()
    }

}
