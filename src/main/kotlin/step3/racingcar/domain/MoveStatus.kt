package step3.racingcar.domain

import step3.racingcar.expansion.greaterOrEqual

enum class MoveStatus {
    ACCELERATION, BREAK;

    fun isGo(): Boolean = this == ACCELERATION

    companion object {
        private const val ACCELERATION_CRITERIA = 4
        fun match(randomNumber: Int): MoveStatus {
            if (randomNumber.greaterOrEqual(ACCELERATION_CRITERIA)) {
                return ACCELERATION
            }
            return BREAK
        }
    }
}
