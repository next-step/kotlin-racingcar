package game.racingcar

import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy

class RacingCar(
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
    var location: Int = 0,
) {
    fun move() {
        if (moveStrategy.movable()) {
            location += 1
        }
    }
}
