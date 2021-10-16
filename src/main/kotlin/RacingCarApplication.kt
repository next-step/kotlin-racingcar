import view.InputView
import view.ResultView
import view.ResultView.Companion.RESULT_TITLE

/**
 * 자동차 경주 게임의 메인 class
 * */
fun main() {
    val carCount = InputView().requestNumberOfCar()
    val tryCount = InputView().requestTryCount()
    require(carCount > 0 && tryCount > 0) { "1이상의 값을 입력주새셔야 게임을 진행할 수 있습니다." }

    ResultView().printResultTitle(RESULT_TITLE)
    ResultView().printRace(carCount, tryCount)
}
