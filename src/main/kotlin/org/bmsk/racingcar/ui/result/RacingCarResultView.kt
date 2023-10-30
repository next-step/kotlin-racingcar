package org.bmsk.racingcar.ui.result

import org.bmsk.racingcar.domain.model.Car
import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.policy.movement.MovementPolicy
import org.bmsk.racingcar.domain.policy.movement.RandomMovementImpl

class RacingCarResultView(
    private val movementPolicy: MovementPolicy = RandomMovementImpl(),
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
