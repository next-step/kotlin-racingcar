package racingCarMVC.controller

import racingCarMVC.domain.RacingService
import racingCarMVC.domain.dto.InputData
import racingCarMVC.domain.dto.RacingPlayers
import racingCarMVC.view.InputMessage
import racingCarMVC.view.InputView
import racingCarMVC.view.ResultView

class RacingController {
    private val inputView = InputView()
    private val racingService = RacingService()
    private val resultView = ResultView()

    fun inputData(): InputData {
        inputView.show(InputMessage.CAR_NAMES)
        val carNames = racingService.inputCarNames()

        inputView.show(InputMessage.GAME_COUNT)
        val gameCount = racingService.inputGameCount()

        return InputData(carNames, gameCount)
    }

    fun racingStart(inputData: InputData) {
        val racingResult = racingService.racingStart(inputData)
        val winners = RacingPlayers(racingResult.last().players).getWinners()

        resultView.showRacingResult(racingResult, winners)
    }
}