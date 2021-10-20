import racingcar.model.Cars
import racingcar.model.DriveRule
import racingcar.view.InputView
import racingcar.view.ResultView

/**
 * 자동차 경주 게임의 메인 class
 * */
private val inputView = InputView()
private val resultView = ResultView()

fun main() {
    val driveRule = DriveRule()
    val condition = inputView.inputRaceCondition()
    val carList = Cars.createCars(condition, driveRule)

    resultView.run {
        printResultTitle(ResultView.RESULT_TITLE)
        repeat(condition.tryCount) {
            printStartRound(it)
            printRace(carList.race())
            printEndRound()
        }
        printRaceResult(carList.getWinner())
    }
}
