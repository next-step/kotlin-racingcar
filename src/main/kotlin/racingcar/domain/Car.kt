package racingcar.domain

import java.util.concurrent.ThreadLocalRandom


data class Car(
    val name: String,
    val position: Position = Position(POSITION_FIRST),
) {

    init {
        validateNameLength()
    }

    fun move(terms: Int = ThreadLocalRandom.current().nextInt(TERMS_OF_RACING_MIN, TERMS_OF_RACING_MAX)): Car {
        return if (isMove(terms))
            Car(name, Position(position.value + POSITION_MOVE))
        else this
    }

    private fun validateNameLength() {
        if (name.length > TERMS_CAR_NAME_LENGTH) throw IllegalArgumentException("자동차 이름은 ${TERMS_CAR_NAME_LENGTH}글자를 초과할 수 없습니다.")
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

        private const val TERMS_CAR_NAME_LENGTH = 5
    }

}