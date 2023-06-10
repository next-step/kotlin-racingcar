package step3.workflow

import step3.entity.RacingCar

class GetWinners {
    operator fun invoke(racingCars: List<RacingCar>): List<RacingCar> {
        val finalLine = racingCars.maxBy { it.position }.position
        return racingCars.filter { it.position == finalLine }
    }
}
