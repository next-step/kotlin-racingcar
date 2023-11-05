package racingcar

class Wheel {
    fun nextLocation(power: Int): Int {
        if (isInValidPower(power)) {
            throw IllegalArgumentException("유효하지 않은 power 입니다")
        }
        return if (isMovablePower(power)) {
            1
        } else {
            return 0
        }
    }

    private fun isInValidPower(power: Int) =
        power < VALID_MIN_POWER || power > VALID_MAX_POWER

    private fun isMovablePower(power: Int) =
        power in MOVABLE_MIN_POWER..VALID_MAX_POWER

    companion object {
        const val VALID_MIN_POWER = 0
        const val VALID_MAX_POWER = 9
        const val MOVABLE_MIN_POWER = 4
    }
}
