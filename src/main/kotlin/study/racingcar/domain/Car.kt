package study.racingcar.domain

import study.racingcar.common.GameConfig

class Car {
    var moveCount: Int = 1
        private set
    fun move(randomValue: Int) {
        if (!isMovable(randomValue)) return
        moveCount++
    }

    private fun isMovable(randomValue: Int): Boolean = randomValue >= GameConfig.MOVABLE_VALUE
}
