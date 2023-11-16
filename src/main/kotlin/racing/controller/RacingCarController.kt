package racing.controller

import racing.service.RacingCarService
import racing.view.InputView
import racing.view.ResultView

class RacingCarController(private val racingCarService: RacingCarService) {
    fun startRacingGame() {
        val carNames = InputView.inputCarNames()
        val tryCount = InputView.inputTryCount()

        val cars = racingCarService.prepareRacingGame(carNames)

        for (i in 0 until tryCount) {
            val racingCars = racingCarService.startRacingGame(cars)
            ResultView.printResult(racingCars)
        }
        ResultView.printWinner(cars)
    }
}
