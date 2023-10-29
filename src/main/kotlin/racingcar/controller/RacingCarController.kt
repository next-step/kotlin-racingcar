package racingcar.controller

import racingcar.domain.car.CarFactory
import racingcar.domain.race.Race
import racingcar.domain.race.RandomRacePolicy
import racingcar.view.RacingCarInputView
import racingcar.view.RacingCarResultView

object RacingCarController {
    fun handle() {
        val racingCarInput = RacingCarInputView.readInput()

        val race = Race(
            cars = CarFactory.createCars(racingCarInput.carNames),
            totalRound = racingCarInput.totalRound,
            racePolicy = RandomRacePolicy,
        )
        val raceResult = race.start()

        RacingCarResultView.printResult(raceResult.resultPerRound, racingCarInput.carNames)
    }
}
