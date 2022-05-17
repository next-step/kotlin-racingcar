package racingcar.controller

import racingcar.domain.Drivers
import racingcar.domain.strategy.MoveStrategy
import racingcar.domain.strategy.NameStrategy
import racingcar.dto.MoveResults
import racingcar.exception.GameOverException

class RacingGame(carNames: List<String>, trialCount: Int, moveStrategy: MoveStrategy, nameStrategy: NameStrategy) {
    private val drivers: Drivers = Drivers(carNames, moveStrategy, nameStrategy)
    private var _results: MutableList<MoveResults> = mutableListOf()
    private var _trialCount: Int = trialCount

    val trialCount get() = _trialCount
    val results: List<MoveResults> get() = _results

    fun play() {
        if (!isPlayable()) {
            throw GameOverException()
        }
        drivers.driveAll()
        _results.add(drivers.getMoveResults())
        reduceTrialCount()
    }

    fun isPlayable(): Boolean {
        return trialCount > GAME_END_COUNT
    }

    private fun reduceTrialCount() {
        _trialCount--
    }

    fun getWinners(): List<String> {
        return drivers.getWinnerResults()
            .map { it.carName }
    }

    companion object {
        private const val GAME_END_COUNT = 0
    }
}
