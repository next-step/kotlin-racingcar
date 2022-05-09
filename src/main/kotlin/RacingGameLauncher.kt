import racingcar.application.RacingGameManager
import racingcar.ui.InputView
import racingcar.ui.ResultView

object RacingGameLauncher {
    fun launch() {
        val gameInput = InputView.read()

        val gameResult = RacingGameManager.proceed(gameInput)

        ResultView.show(gameResult)
    }
}

fun main() {
    RacingGameLauncher.launch()
}
