package racingcar.domain

import racingcar.util.NumGenerator

private const val RANDOM_NUM_BOUND = 10

class RacingCarGame private constructor(
    var racingCars: List<RacingCar>
) {

    fun race(numGenerator: NumGenerator) {
        val newRacingCars = mutableListOf<RacingCar>()
        for (racingCar in racingCars) {
            val randomNum = numGenerator.getNextInt(RANDOM_NUM_BOUND)
            val nextStepRacingCar = racingCar.moveOrStop(randomNum)
            newRacingCars.add(nextStepRacingCar)
        }
        racingCars = newRacingCars
    }

    fun calculateWinners(): List<RacingCar> {
        val maxCount = racingCars.maxBy { racingCar -> racingCar.count }.count
        return racingCars.filter { racingCar -> racingCar.count == maxCount }
    }

    companion object {
        fun init(racingCars: List<RacingCar>): RacingCarGame {
            return RacingCarGame(racingCars)
        }
    }
}
