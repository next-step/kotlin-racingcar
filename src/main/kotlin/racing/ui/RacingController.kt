package racing.ui

import racing.application.RacingInfo
import racing.application.RacingService
import racing.domain.Capacity
import racing.domain.Cars

class RacingController(
    private val racingService: RacingService,
    private val racingInput: RacingInput,
    private val racingOutput: RacingOutput
) {

    fun startRacing() {
        val cars = Cars(racingInput.requestCarNames())
        val numberOfRound = racingInput.requestNumberOfRound()

        val racingResult =
            racingService.racing(RacingInfo(round = Capacity(numberOfRound), cars = cars))

        racingOutput.printRacingResult(racingResult)
    }
}
