package step3.racingcar.car

import step3.racingcar.RandomNumberGenerator
import step3.racingcar.car.exception.GameOverException

class RacingGame private constructor(
    private val drivers: List<Driver>,
    private var _trialCount: Int
) {
    val trialCount get() = _trialCount

    fun play() {
        if (isPlayable()) {
            drivers.forEach {
                it.drive(RandomNumberGenerator.generate())
            }
        }
        reduceTrialCount()
    }

    fun getPlayResults(): List<Int> {
        return drivers.map { it.getMoveResult() }
    }

    fun isPlayable(): Boolean {
        if (trialCount <= GAME_END_COUNT) {
            throw GameOverException()
        }
        return true
    }

    private fun reduceTrialCount() {
        _trialCount--
    }

    companion object {
        private const val GAME_END_COUNT = 0

        fun init(numberOfCar: Int, trialCount: Int): RacingGame {
            val drivers = List(numberOfCar) { Driver(Car()) }
            return RacingGame(drivers, trialCount)
        }
    }
}
