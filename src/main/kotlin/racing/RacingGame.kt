package racing

import racing.car.CarManager
import racing.rule.Rule
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val rule = Rule()
    val carManager = CarManager(rule)
    val racing = Racing(carManager)

    val inputCarNames = InputView.inputCarName()
    val inputRacingCnt = InputView.inputRacingCnt()

    carManager.createCarList(inputCarNames)
    carManager.validateCarList()

    racing.startRacing(inputRacingCnt.toInt())

    ResultView.showRacingResult(racing.racingResultList)
}
