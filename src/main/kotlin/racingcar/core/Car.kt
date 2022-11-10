package racingcar.core

import racingcar.ui.MessageCode
import java.lang.IllegalArgumentException
import java.util.Random

class Car(
    private val tryNumber: Int
) {
    private fun getRandomNumber(): Int =
        Random().nextInt(RANDOM_BOUND)

    private fun isMovable(): Boolean {
        return getRandomNumber() > MOVE_LIMIT
    }

    fun move(): String {
        if (tryNumber < INIT_TRY_NUMBER) throw IllegalArgumentException(MessageCode.TryNumberException.message)
        return (INIT_TRY_NUMBER..tryNumber).filter { isMovable() }.joinToString(SEPARATOR) { MOVE_STEP }
    }

    companion object {
        const val INIT_TRY_NUMBER = 1
        const val INIT_CAR_NUMBER = 0
        private const val RANDOM_BOUND = 10
        private const val MOVE_LIMIT = 4
        private const val MOVE_STEP = "-"
        private const val SEPARATOR = " "
    }
}
