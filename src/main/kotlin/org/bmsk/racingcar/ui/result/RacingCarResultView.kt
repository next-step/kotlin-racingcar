package org.bmsk.racingcar.ui.result

import org.bmsk.racingcar.domain.model.Car
import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.policy.MovementPolicy

class RacingCarResultView(
    private val movementPolicy: MovementPolicy = MovementPolicy.RandomMovement(),
) {
    private lateinit var racingCarRoad: RacingCarRoad

    fun initRacingCarRoad(numberOfCars: Int) {
        List(numberOfCars) { Car(movementPolicy) }.let {
            racingCarRoad = RacingCarRoad(it)
        }
    }

    fun getCarRaceResult(numberOfAttempts: Int): List<RacingCarRoad> {
        return (1..numberOfAttempts).fold(mutableListOf(racingCarRoad)) { acc, _ ->
            acc.apply { add(last().getMovedRacingCarRoad()) }
        }
    }
}
