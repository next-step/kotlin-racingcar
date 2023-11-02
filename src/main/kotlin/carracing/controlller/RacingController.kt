package carracing.controlller

import carracing.model.model.Racing
import carracing.model.model.Snapshot
import carracing.model.service.RacingService
import carracing.util.toIntOrThrow
import carracing.view.InputView
import carracing.view.OutputView

class RacingController {
    private val racingService = RacingService()

    fun create(): Racing {
        val numberOfCar = InputView.getNumberOfCar()
            .toIntOrThrow { "'numberOfCar' must be a number" }
        return racingService.create(numberOfCar)
    }

    fun play(racing: Racing): List<Snapshot> {
        val numberOfAttempt = InputView.getNumberOfAttempt()
            .toIntOrThrow { "'numberOfAttempt' must be a number" }
        return racingService.play(racing, numberOfAttempt)
    }

    fun printSnapshots(snapshots: List<Snapshot>) {
        OutputView.printResult(snapshots)
    }
}
