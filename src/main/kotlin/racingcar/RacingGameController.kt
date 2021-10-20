package racingcar

import racingcar.model.Cars
import racingcar.model.DriveRule
import racingcar.view.InputView
import racingcar.view.ResultView

/**
 * 자동차 경주 게임의 view & model의 비즈니스 로직을 가지는 객체
 * */
class RacingGameController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val driveRule = DriveRule()

    fun startGame() {
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
}
