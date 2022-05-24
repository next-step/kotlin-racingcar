package com.nextstep.jngcii.racingcar.domain

open class Car(val name: String) {
    open val speed = SPEED
    private var _distance = ZERO_DISTANCE
    open val distance get() = _distance

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("자동차이름은 공백일 수 없습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("자동차이름은 ${MAX_CAR_NAME_LENGTH}자를 초과할 수 없습니다.")
        }
    }

    open fun go(dice: Dice) {
        _distance += if (dice.run()) speed else ZERO_DISTANCE
    }

    companion object {
        private const val ZERO_DISTANCE = 0
        private const val SPEED = 1
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
