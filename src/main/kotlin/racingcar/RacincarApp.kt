import racingcar.domain.RacingGame
import racingcar.generate
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()

    val carNames = inputView.readCarNames()
    val tryCnt = inputView.readTryCount()

    val playRecord = RacingGame(carNames, tryCnt).play {
        generate()
    }

    ResultView().view(playRecord)
}
