package study.racing.process

import study.racing.domain.Cars
import study.racing.domain.Round

class Racing {

    fun playRacing(
        carNames: String,
        roundCount: Int
    ): List<Cars> {
        val round = Round(roundCount)
        val racingCars = Cars.from(carNames)

        val copyCars = mutableListOf<Cars>()
        repeat(round.roundCount) {
            racingCars.moveTheCars()
            copyCars.add(racingCars.copy())
        }

        return copyCars
    }
}
