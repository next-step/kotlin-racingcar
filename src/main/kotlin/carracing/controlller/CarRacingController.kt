package carracing.controlller

import carracing.domain.Car
import carracing.domain.Racing
import carracing.domain.Snapshot
import carracing.util.requireNotNullOrBlank
import carracing.util.toIntOrThrow
import carracing.view.InputView
import carracing.view.OutputView

class CarRacingController {

    fun organize(): Racing {
        val cars = InputView.getNamesOfCars()
            .requireNotNullOrBlank { "'namesOfCars' must not be blank or null" }
            .split(",")
            .map { Car(it) }
        return Racing(cars = cars)
    }

    fun play(racing: Racing) {
        val numberOfAttempt = InputView.getNumberOfAttempt()
            .toIntOrThrow { "'numberOfAttempt' must be a number" }
        require(numberOfAttempt > 0) { "'numberOfAttempt' must be greater than 0" }
        val snapshots: List<Snapshot> = racing.playRoundsWithSnapshots(numberOfAttempt)
        OutputView.printResult(snapshots)
    }

    fun finish(racing: Racing) {
        val winners: List<String> = racing.finish()
        OutputView.printWinners(winners)
    }
}
