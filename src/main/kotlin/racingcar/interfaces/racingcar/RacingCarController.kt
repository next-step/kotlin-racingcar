package racingcar.interfaces.racingcar

import racingcar.application.car.CarRacingService
import racingcar.view.PromptService

class RacingCarController(
    private val promptService: PromptService,
    private val carRacingService: CarRacingService
) {
    fun startGame() {
        val racingResults = carRacingService.run(
            nameOfCars = promptService.getNameOfCars(),
            moves = promptService.getNumberOfMoves()
        )

        val winners = carRacingService.findWinners(finalResult = racingResults.last())

        promptService.showResult(racingResults, winners)
    }
}
