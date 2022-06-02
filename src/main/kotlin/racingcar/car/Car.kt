package racingcar.car

import racingcar.car.engine.Engine

private const val INIT_POSITION = 0

class Car(private val engine: Engine, val name: String = "이름없음") {
    private val position = mutableMapOf<Int, Int>()

    fun positionBy(moveCount: Int): Int =
        if (moveCount < 1) {
            INIT_POSITION
        } else {
            position.getOrPut(moveCount) { positionBy(moveCount - 1) + engine.advancePoint() }
        }
}
