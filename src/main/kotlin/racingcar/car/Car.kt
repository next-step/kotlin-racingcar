package racingcar.car

import racingcar.engine.Engine

class Car(private val engine: Engine) {
    private val position = mutableMapOf<Int, Int>()

    fun positionBy(moveCount: Int): Int = if (moveCount < 1) INIT_POSITION else position.getOrPut(moveCount) {
        positionBy(moveCount - 1) + engine.advancePoint()
    }

    companion object {
        private const val INIT_POSITION = 0
    }
}
