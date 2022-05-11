package step3.racingcar.car

import step3.racingcar.RandomNumberGenerator

class RacingGame private constructor(
    private val drivers: List<Driver>,
    private val trialCount: Int
) {

    fun play() {
        repeat(trialCount) {
            drivers.forEach {
                it.drive(RandomNumberGenerator.generate())
            }
        }
    }

    fun getPlayResult(): List<Int> {
        return drivers.map { it.getMoveResult() }
    }

    companion object {
        fun init(numberOfCar: Int, trialCount: Int): RacingGame {
            val drivers = List(numberOfCar) { Driver(Car()) }
            return RacingGame(drivers, trialCount)
        }
    }
}
