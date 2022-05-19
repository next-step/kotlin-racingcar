package racingcar.controller

import racingcar.domain.Drivers
import racingcar.domain.strategy.MoveStrategy
import racingcar.domain.strategy.NameStrategy
import racingcar.dto.MoveResults

class RacingGame(carNames: List<String>, private val trialCount: Int, moveStrategy: MoveStrategy, nameStrategy: NameStrategy) {
    private val drivers: Drivers = Drivers(carNames, moveStrategy, nameStrategy)
    private val _results: MutableList<MoveResults> = mutableListOf()

    val results: List<MoveResults> get() = _results.toList()

    fun play() {
        repeat(trialCount) {
            drivers.driveAll()
            _results.add(drivers.getMoveResults())
        }
    }

    fun isPlayable(): Boolean {
        return trialCount > GAME_END_COUNT
    }

    fun getWinners(): List<String> {
        return drivers.getWinnerResults()
            .map { it.carName }
    }

    companion object {
        private const val GAME_END_COUNT = 0
    }
}
