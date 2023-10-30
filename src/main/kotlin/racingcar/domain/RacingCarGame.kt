package racingcar.domain

import racingcar.util.NumGenerator

class RacingCarGame private constructor(
    var racingCars: List<RacingCar>
) {

    fun race(numGenerator: NumGenerator) {
        racingCars = racingCars.map {
            val randomNum = numGenerator.getNextInt()
            it.moveOrStop(randomNum)
        }
    }

    fun findWinners(): List<RacingCar> {
        val maxCount = racingCars.maxBy { racingCar -> racingCar.count }.count
        return racingCars.filter { racingCar -> racingCar.count == maxCount }
    }

    companion object {
        fun init(racingCars: List<RacingCar>): RacingCarGame {
            return RacingCarGame(racingCars)
        }
    }
}
