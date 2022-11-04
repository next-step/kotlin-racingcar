package game.racingcar

import game.racingcar.move.MoveStrategy

class RacingCar(
    private val moveStrategy: MoveStrategy,
    var location: Int = 0,
) {
    fun move() {
        if (moveStrategy.movable()) {
            location += 1
        }
    }
}
