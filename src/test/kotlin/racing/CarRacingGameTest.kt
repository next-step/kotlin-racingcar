package racing

import org.junit.jupiter.api.Test
import racing.model.CarInput
import racing.model.Name
import racing.model.Names
import racing.model.Times
import racing.ui.ResultView

class CarRacingGameTest {
    @Test
    fun `레이싱 게임 테스트`() {
        val racingGame = CarRacingGame(CarInput(Names(listOf(Name("pobi"), Name("crong"), Name("honux"))), Times(5)))
        val result = racingGame.start()
        ResultView(result).printResult()
    }
}
