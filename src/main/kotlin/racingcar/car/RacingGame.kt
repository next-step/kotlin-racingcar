package racingcar.car

import racingcar.car.exception.GameOverException
import racingcar.car.strategy.MoveStrategy

class RacingGame(numberOfCar: Int, trialCount: Int, strategy: MoveStrategy) {
    private val drivers: List<Driver> = List(numberOfCar) { Driver(Car(), strategy) }
    private var _trialCount: Int = trialCount

    val trialCount get() = _trialCount

    fun play() {
        if (isPlayable()) {
            drivers.forEach { driver ->
                driver.drive()
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
    }
}
