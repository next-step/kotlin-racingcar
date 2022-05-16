package racing

import racing.controller.RacingController
import racing.infra.RandomCarMovingStepper
import racing.service.CarService
import racing.utils.InputUtils
import racing.utils.ScreenView

fun main() {
    val racingController = RacingController(CarService(RandomCarMovingStepper()))

    val carNum = InputUtils.inputCarNum()
    val round = InputUtils.inputRound()

    val resultViews = racingController.playGame(carNum, round)
    ScreenView.view(resultViews)
}
