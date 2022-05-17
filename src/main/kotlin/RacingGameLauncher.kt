import racingcar.application.RacingGameManager
import racingcar.domain.RandomDriver
import racingcar.ui.InputView
import racingcar.ui.ResultView

object RacingGameLauncher {
    fun launch() {
        val gameInput = InputView.read()

        val gameResult = RacingGameManager.play(gameInput, RandomDriver)

        ResultView.show(gameResult)
    }
}

fun main() {
    RacingGameLauncher.launch()
}
