package racing

import racing.controller.RacingController
import racing.infra.RandomMovingRule
import racing.service.CarService
import racing.utils.InputUtils
import racing.utils.ScreenView

fun main() {
    val racingController = RacingController(CarService(RandomMovingRule()))

    val carNum = InputUtils.inputCarNum()
    val round = InputUtils.inputRound()

    val resultViews = racingController.playGame(carNum, round)
    ScreenView.view(resultViews)
}
