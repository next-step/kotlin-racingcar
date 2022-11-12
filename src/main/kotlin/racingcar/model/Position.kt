package racingcar.model

import racingcar.domain.GameManager

data class Position(var value: Int = 0) {

    init {
        GameManager.validateNegativeNumber(this.value)
    }

    constructor(input: String) : this() {
        this.value = GameManager.validateNegativeStringNumber(input)
    }

    fun plus() {
        this.value += FORWARD_VALUE
    }

    companion object {
        private const val FORWARD_VALUE = 1
    }

    operator fun compareTo(other: Position): Int =
        when {
            this.value > other.value -> 1
            this.value < other.value -> -1
            else -> 0
        }
}
