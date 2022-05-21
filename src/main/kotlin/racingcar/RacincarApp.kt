import racingcar.domain.RacingGame
import racingcar.generate
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()

    val carCnt = inputView.readCarCount()
    val tryCnt = inputView.readTryCount()

    val playRecord = RacingGame(carCnt, tryCnt).play {
        generate()
    }

    ResultView().view(playRecord)
}
