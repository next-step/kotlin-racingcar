package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.WinnerCar
import racingcar.dto.CarsDto
import racingcar.service.RacingService
import racingcar.view.OutputView
import racingcar.view.OutputView.printWinners
import racingcar.view.inputCarName

class RacingController(
    private val racingService: RacingService = RacingService()
) {
    fun play(): CarsDto {
        val snapshots = racingService.play(join())
        OutputView.printRacing(snapshots)
        return snapshots.last()
    }

    private fun join(): Cars = Cars.of(inputCarName())

    fun win(playRacingCar: CarsDto) {
        printWinners(WinnerCar.from(playRacingCar))
    }
}
