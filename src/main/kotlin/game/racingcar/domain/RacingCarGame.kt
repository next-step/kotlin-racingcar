package game.racingcar.domain

import game.racingcar.dto.CarLocationSnapshot
import game.racingcar.dto.RacingCarPlayResult

class RacingCarGame(
    private val numberOfTrials: Int,
    private val racingCars: RacingCars
) {
    fun play(): RacingCarPlayResult {
        return (1..numberOfTrials)
            .map { racingCars.moveAll() }
            .map { CarLocationSnapshot(it) }
            .let { RacingCarPlayResult(it, racingCars.pickWinners()) }
    }
}
