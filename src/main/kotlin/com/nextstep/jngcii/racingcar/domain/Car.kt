package com.nextstep.jngcii.racingcar.domain

class Car(
    val name: String,
    private val speed: Int = SPEED,
    private val dice: Dice = Dice { true },
    advantage: Int? = null
) {
    private var _distance = advantage ?: ZERO_DISTANCE
    val distance get() = _distance

    init {
        require(name.isNotBlank()) { "자동차이름은 공백일 수 없습니다." }
        require(name.length <= MAX_CAR_NAME_LENGTH) { "자동차이름은 ${MAX_CAR_NAME_LENGTH}자를 초과할 수 없습니다." }
    }

    fun goOrStayByDiceCondition() {
        _distance += if (dice.run()) speed else ZERO_DISTANCE
    }

    companion object {
        private const val ZERO_DISTANCE = 0
        private const val SPEED = 1
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
