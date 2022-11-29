package racingcar

import racingcar.application.car.CarRacingService
import racingcar.interfaces.racingcar.RacingCarController
import racingcar.view.InputViewImpl
import racingcar.view.PromptServiceImpl
import racingcar.view.ResultView

fun main() {
    val promptService = PromptServiceImpl(InputViewImpl(), ResultView())
    val carRacingService = CarRacingService()
    val racingController = RacingCarController(promptService, carRacingService)

    racingController.startGame()
}
