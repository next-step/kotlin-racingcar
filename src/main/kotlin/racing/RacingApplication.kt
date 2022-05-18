package racing

import racing.controller.RacingController
import racing.infra.RandomCarMovingStepper
import racing.service.CarService
import racing.utils.ScreenView
import racing.utils.inputCarUser
import racing.utils.inputRound

fun main() {
    val racingController = RacingController(CarService(RandomCarMovingStepper()))

    val users = inputCarUser()
    val round = inputRound()

    val resultViews = racingController.playGame(users, round)
    ScreenView.view(resultViews)
}
