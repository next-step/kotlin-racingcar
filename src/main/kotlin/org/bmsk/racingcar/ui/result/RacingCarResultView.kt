package org.bmsk.racingcar.ui.result

import org.bmsk.racingcar.domain.model.Car
import org.bmsk.racingcar.domain.model.RacingCarRoad
import org.bmsk.racingcar.domain.policy.movement.MovementPolicy
import org.bmsk.racingcar.domain.policy.movement.RandomMovementImpl
import org.bmsk.racingcar.domain.policy.ranking.MultipleWinnersAllowedImpl
import org.bmsk.racingcar.domain.policy.ranking.RankingPolicy

class RacingCarResultView(
    private val movementPolicy: MovementPolicy = RandomMovementImpl(),
    private val rankingPolicy: RankingPolicy = MultipleWinnersAllowedImpl(),
) {
    private lateinit var racingCarRoad: RacingCarRoad

    fun initRacingCarRoad(numberOfCars: Int) {
        List(numberOfCars) { Car(movementPolicy) }.let {
            racingCarRoad = RacingCarRoad(it)
        }
    }

    fun initRacingCarRoad(numberOfCars: Int, namesOfCars: List<String>) {
        require(numberOfCars == namesOfCars.size) { "numberOfCars의 수와 namesOfCars의 사이즈가 같아야 합니다. <$numberOfCars, ${namesOfCars.size}>" }
        List(numberOfCars) { Car(movementPolicy = movementPolicy, name = namesOfCars[it]) }.let {
            racingCarRoad = RacingCarRoad(it)
        }
    }

    fun getCarRacingRoadsResult(numberOfAttempts: Int): List<RacingCarRoad> {
        return (1..numberOfAttempts).fold(mutableListOf(racingCarRoad)) { acc, _ ->
            acc.apply { add(last().getMovedRacingCarRoad()) }
        }.drop(1)
    }

    fun getCarRacingResultWinners(racingCarRoad: RacingCarRoad): List<Car> {
        return when (rankingPolicy) {
            is RankingPolicy.MultipleWinnersAllowed -> rankingPolicy.determineWinner(racingCarRoad).cars
            is RankingPolicy.SingleWinnerOnly -> listOf(rankingPolicy.determineWinner(racingCarRoad).car)
        }
    }
}
