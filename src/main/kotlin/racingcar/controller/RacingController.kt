package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.WinnerCar
import racingcar.service.RacingService
import racingcar.view.OutputView.printWinners
import racingcar.view.inputCarName

class RacingController(
    private val racingService: RacingService = RacingService()
) {
    fun play(): Cars {
        return racingService.play(join())
    }

    private fun join(): Cars = Cars.of(inputCarName().split(RACING_CAR_DELIMITER))

    fun win(playRacingCar: Cars) {
        printWinners(WinnerCar.from(playRacingCar))
    }

    companion object {
        private const val RACING_CAR_DELIMITER = ","
    }
}
