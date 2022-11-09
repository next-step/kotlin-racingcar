package game.racingcar.domain

import game.racingcar.dto.CarLocationSnapshot
import game.racingcar.dto.RacingCarPlayResult
import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy

class RacingCarGame(
    private val carNames: List<String>,
    private val numberOfTrials: Int,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    fun play(): RacingCarPlayResult {
        val racingCars = RacingCars(carNames, moveStrategy)
        return (1..numberOfTrials)
            .map { racingCars.moveAll() }
            .map { CarLocationSnapshot(it) }
            .let { RacingCarPlayResult(it, racingCars.pickWinners()) }
    }
}
