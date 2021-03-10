package study.racingcar.domain

import study.racingcar.common.GameConfig

class Car(
    val carName: String
) {
    var moveCount: Int = DEFAULT_CAR_MOVE_COUNT
        private set

    constructor(carName: String, moveCount: Int) : this(carName) {
        this.moveCount = moveCount
    }

    fun move(randomValue: Int) {
        if (isMovable(randomValue)) moveCount++
    }

    private fun isMovable(randomValue: Int): Boolean = randomValue >= GameConfig.MOVABLE_VALUE

    override fun toString(): String {
        return "$carName : ${(1..moveCount).joinToString("") { GameConfig.RACE_SYMBOL }}"
    }

    companion object {
        private const val DEFAULT_CAR_MOVE_COUNT = 0
    }
}
