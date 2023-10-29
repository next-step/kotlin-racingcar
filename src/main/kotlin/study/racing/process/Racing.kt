package study.racing.process

import study.racing.domain.Cars
import study.racing.domain.Round
import study.racing.view.RacingView

class Racing {

    fun playRacing(
        carNames: String,
        roundCount: Int
    ) {
        val round = Round(roundCount)
        val racingCars = Cars.from(carNames)

        repeat(round.roundCount) {
            racingCars.moveTheCars()
            RacingView.printRacingResult(racingCars)
        }
    }
}
