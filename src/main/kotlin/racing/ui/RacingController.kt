package racing.ui

import racing.application.RacingService

class RacingController(
    private val racingService: RacingService,
    private val racingInput: RacingInput,
    private val racingOutput: RacingOutput
) {

    fun startRacing() {
        val racingGameRequest = racingInput.requestRacingGameInfo()

        val racingResult =
            racingService.racing(racingGameRequest)

        racingOutput.printRacingResult(racingResult)
    }
}
