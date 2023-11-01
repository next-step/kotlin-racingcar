package carracing.controlller

import carracing.model.model.Racing
import carracing.model.model.Snapshot
import carracing.model.service.RacingService
import carracing.view.InputTemplate
import carracing.view.OutputTemplate
// import study.util.requireNotNullOrBlank

class RacingController {
    val RacingService = RacingService()

    fun create(): Racing {
        val numberOfCar = InputTemplate.getNumberOfCar()!!
            // .requireNotNullOrBlank { "'numberOfCar' must be a number" }
            .toInt()
        return RacingService.create(numberOfCar)
    }

    fun play(racing: Racing): List<Snapshot> {
        val numberOfAttempt = InputTemplate.getNumberOfAttempt()!!
            // .requireNotNullOrBlank { "'numberOfAttempt' must be a number" }
            .toInt()
        return RacingService.play(racing, numberOfAttempt)
    }

    fun printSnapshots(snapshots: List<Snapshot>) {
        OutputTemplate.printResult(snapshots)
    }
}
