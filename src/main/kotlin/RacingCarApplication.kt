import exception.Exception.Companion.CASE_INPUT_DATA_WRONG
import view.InputView
import view.ResultView
import view.ResultView.Companion.RESULT_TITLE

/**
 * 자동차 경주 게임의 메인 class
 * */
fun main() {
    val carCount = InputView().requestNumberOfCar()
    val tryCount = InputView().requestTryCount()
    require(carCount > 0 && tryCount > 0) { CASE_INPUT_DATA_WRONG }

    ResultView().run {
        printResultTitle(RESULT_TITLE)
        printRace(carCount, tryCount)
        printEndRound()
    }
}
