package study.racing.controller

import study.racing.domain.Cars
import study.racing.process.Racing
import study.racing.view.RacingView

class RacingController(
    private val racing: Racing = Racing()
) {

    fun startRacingGame(
        carNames: String,
        roundCount: Int
    ): List<Cars> {
        return racing.playRacing(carNames, roundCount)
    }
}