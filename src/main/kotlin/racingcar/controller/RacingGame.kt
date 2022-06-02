package racingcar.controller

import racingcar.domain.Drivers
import racingcar.domain.strategy.MoveStrategy
import racingcar.dto.MoveResults

class RacingGame(
    private val drivers: Drivers,
    private val trialCount: Int,
    private val moveStrategy: MoveStrategy,
) {
    private val _results: MutableList<MoveResults> = mutableListOf()

    val results: List<MoveResults> get() = _results.toList()

    fun play() {
        repeat(trialCount) {
            drivers.driveAll(moveStrategy)
            _results.add(drivers.getMoveResults())
        }
    }

    fun getWinners(): MoveResults {
        return drivers.getWinnerResults()
    }
}
