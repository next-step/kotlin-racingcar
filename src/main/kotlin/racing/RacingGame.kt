package racing

import racing.domain.CarMoveLogic
import racing.domain.Racing
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val inputCarNames = InputView.inputCarName()
    val inputPlayCnt = InputView.inputRacingPlayCnt()

    val playCarList = CarListFactory.createPlayCarList(inputCarNames)
    val racing = Racing(playCarList, CarMoveLogic())

    racing.play(inputPlayCnt.toInt())

    ResultView.showRacingResult(racing.result)
}
