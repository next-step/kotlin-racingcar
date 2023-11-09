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

    fun play(racing: Racing): List<Snapshot> {
        val numberOfAttempt = InputView.getNumberOfAttempt()
            .toIntOrThrow { "'numberOfAttempt' must be a number" }
        require(numberOfAttempt > 0) { "'numberOfAttempt' must be greater than 0" }
        return racing.playRoundsWithSnapshots(numberOfAttempt)
    }

    fun printSnapshots(snapshots: List<Snapshot>) {
        OutputView.printResult(snapshots)
    }
}
