package org.bmsk.racingcar.ui.result

import org.bmsk.effectivekotlin.domain.model.Car
import org.bmsk.effectivekotlin.domain.model.RacingCarRoad
import org.bmsk.effectivekotlin.domain.model.RacingCarWinner
import org.bmsk.effectivekotlin.domain.policy.movement.MovementPolicy
import org.bmsk.effectivekotlin.domain.policy.movement.RandomMovementImpl
import org.bmsk.effectivekotlin.domain.policy.ranking.MultipleWinnersAllowedImpl
import org.bmsk.effectivekotlin.domain.policy.ranking.RankingPolicy

class RacingCarResultView(
    private val movementPolicy: MovementPolicy = RandomMovementImpl(),
    private val rankingPolicy: RankingPolicy = MultipleWinnersAllowedImpl(),
) {
    private lateinit var racingCarRoad: RacingCarRoad

    fun initRacingCarRoad(numberOfCars: Int, namesOfCars: List<String>) {
        require(numberOfCars == namesOfCars.size) { "numberOfCars의 수와 namesOfCars의 사이즈가 같아야 합니다. <$numberOfCars, ${namesOfCars.size}>" }
        List(numberOfCars) { Car(movementPolicy = movementPolicy, name = namesOfCars[it]) }.let {
            racingCarRoad = RacingCarRoad(it)
        }
    }

    fun getCarRacingRoadsResult(numberOfAttempts: Int): List<RacingCarRoad> {
        return (1..numberOfAttempts).fold(mutableListOf(racingCarRoad)) { acc, _ ->
            acc.apply { add(last().makeAllCarsMove()) }
        }.drop(1)
    }

    fun getCarRacingResultWinners(racingCarRoad: RacingCarRoad): RacingCarWinner {
        return rankingPolicy.determineWinner(racingCarRoad)
    }
}
