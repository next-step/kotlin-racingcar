package step3.workflow

import step3.entity.RacingCar

class GetWinners {
    operator fun invoke(racingCars: List<RacingCar>): List<RacingCar> {
        val winner = racingCars.maxBy { it }
        return racingCars.filter { it.isOnSameLineWith(winner) }
    }
}
