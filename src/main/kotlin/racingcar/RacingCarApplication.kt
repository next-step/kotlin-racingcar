import racingcar.Cars
import racingcar.view.InputView
import racingcar.view.ResultView

/**
 * 자동차 경주 게임의 메인 class
 * */
private val inputView = InputView()
private val resultView = ResultView()

fun main() {
    val condition = inputView.inputRaceCondition()
    val carList = Cars.createCars(condition)

    resultView.run {
        printResultTitle(ResultView.RESULT_TITLE)
        repeat(condition.tryCount) {
            printStartRound(it)
            printResult(carList.race())
            printEndRound()
        }
    }
}
