package racingcar.controller

import racingcar.service.RacingCarService
import racingcar.view.InputView.inputOperationCar
import racingcar.view.InputView.inputRacingCar
import racingcar.view.ResultView.printResult

class RacingCarController {
    fun start() {
        val carNames = inputRacingCar()
        val operateCount = inputOperationCar()
        val racingCarService = RacingCarService(carNames, operateCount)
        val racingCarResult = racingCarService.startRacing()

        printResult(racingCarResult)
    }
}
