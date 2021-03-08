package study.racingcar.domain

import study.racingcar.common.GameConfig

class Car {
    companion object {
        private const val DEFAULT_CAR_MOVE_COUNT = 0
        private const val MAXIMUM_CAR_NAME_LENGTH = 5
    }

    constructor(carName: String) {
        this.carName = carName
    }

    constructor(carName: String, moveCount: Int) : this(carName) {
        this.moveCount = moveCount
    }

    var carName: String = ""
        private set(value) {
            require(value.length <= MAXIMUM_CAR_NAME_LENGTH) {
                "차량의 이름은 최대 ${MAXIMUM_CAR_NAME_LENGTH}자 까지만 가능합니다."
            }
            field = value
        }
    var moveCount: Int = DEFAULT_CAR_MOVE_COUNT
        private set

    fun move(randomValue: Int) {
        if (isMovable(randomValue)) moveCount++
    }

    private fun isMovable(randomValue: Int): Boolean = randomValue >= GameConfig.MOVABLE_VALUE

    override fun toString(): String {
        return "$carName : ${(1..moveCount).map { GameConfig.RACE_SYMBOL }.joinToString("")}"
    }
}
