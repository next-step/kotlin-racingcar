package racing

import racing.domain.car.CarManager
import racing.domain.Racing
import racing.domain.rule.Rule
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
