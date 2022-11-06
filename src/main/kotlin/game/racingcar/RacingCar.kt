package game.racingcar

import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy
import java.lang.IllegalArgumentException

class RacingCar(
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
    private val name: String = "",
    var location: Int = 0,
) {
    init {
        if (name.length > 5) throw IllegalArgumentException("이름의 길이는 5자를 초과할 수 없습니다.")
    }

    fun move() {
        if (moveStrategy.movable()) {
            location += 1
        }
    }
}
