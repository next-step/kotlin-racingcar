import racingcar.domain.RacingGame
import racingcar.generate
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val carCnt = inputView.readCarCount()
    val tryCnt = inputView.readTryCount()
    val cars = RacingGame(carCnt, tryCnt).execute { generate() }
    ResultView().execute(cars, tryCnt)
}
