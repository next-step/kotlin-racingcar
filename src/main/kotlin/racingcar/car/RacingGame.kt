package racingcar.car

import racingcar.car.exception.GameOverException
import racingcar.car.strategy.MoveStrategy
import racingcar.car.strategy.NameStrategy

class RacingGame(carNames: List<String>, trialCount: Int, moveStrategy: MoveStrategy, nameStrategy: NameStrategy) {
    private val drivers: Drivers = Drivers(carNames, moveStrategy, nameStrategy)
    private var _trialCount: Int = trialCount

    val trialCount get() = _trialCount

    fun play() {
        if (isPlayable()) {
            drivers.driveAll()
        }
        reduceTrialCount()
    }

    fun getPlayResults(): MoveResults {
        return drivers.getMoveResults()
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

    fun getWinners(): List<String> {
        return drivers.getMoveResults().farthestDistanceCarNames
    }

    companion object {
        private const val GAME_END_COUNT = 0
    }
}
