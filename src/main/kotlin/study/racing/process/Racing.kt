package study.racing.process

import study.racing.domain.Cars
import study.racing.domain.Round
import study.racing.view.RacingView

class Racing {

    fun playRacing(
        carCount: Int,
        roundCount: Int
    ) {
        val round = Round(roundCount)
        val racingCars = Cars.from(carCount)

        repeat(round.getRoundCount()) {
            racingCars.moveTheCars()
            RacingView.printRacingResult(racingCars.getCarsMoveDistance())
        }
    }
}
