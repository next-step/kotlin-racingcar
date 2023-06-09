package racing.ui

import racing.application.RacingInfo
import racing.application.RacingService
import racing.domain.Capacity

class RacingController(
    private val racingService: RacingService,
    private val racingInput: RacingInput,
    private val racingOutput: RacingOutput
) {

    fun startRacing() {
        val carCapacity = racingInput.requestNumberOfCars()
        val numberOfRound = racingInput.requestNumberOfRound()

        val racingHistories =
            racingService.racing(RacingInfo(round = Capacity(numberOfRound), capacity = Capacity(carCapacity)))

        racingOutput.printRacingHistories(racingHistories)
    }
}
