package carracing.controlller

import carracing.domain.Car
import carracing.domain.Racing
import carracing.domain.Snapshot
import carracing.util.toIntOrThrow
import carracing.view.InputView
import carracing.view.OutputView

class CarRacingController {

    fun organize(): Racing {
        val numberOfCar = InputView.getNumberOfCar()
            .toIntOrThrow { "'numberOfCar' must be a number" }
        require(numberOfCar > 0) { "'numberOfCar' must be greater than 0" }
        return Racing(cars = List(numberOfCar) { Car() })
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
