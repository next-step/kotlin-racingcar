package racingcar.domain

import java.util.concurrent.ThreadLocalRandom


class Car(
    val position: Position = Position(POSITION_FIRST),
) {

    fun move(terms: Int = ThreadLocalRandom.current().nextInt(TERMS_OF_RACING_MIN, TERMS_OF_RACING_MAX)): Car {
        return if (isMove(terms))
            Car(Position(position.value + POSITION_MOVE))
        else this
    }

    private fun isMove(terms: Int): Boolean {
        val isPass = terms >= TERMS_OF_RACING
        return isPass
    }

    companion object {
        private const val POSITION_FIRST = 1
        private const val POSITION_MOVE = 1

        private const val TERMS_OF_RACING_MIN = 0
        private const val TERMS_OF_RACING_MAX = 10

        private const val TERMS_OF_RACING = 4
    }

}