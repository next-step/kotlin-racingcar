package racingcar.domain


class Car(
    val position: Position = Position(POSITION_FIRST),
) {

    fun move(): Car {
        return if (isMove())
            Car(Position(position.value + POSITION_MOVE))
        else this
    }

    private fun isMove(): Boolean {
        return (TERMS_OF_RACING_MIN..TERMS_OF_RACING_MAX).random() > TERMS_OF_RACING
    }

    companion object {
        private const val POSITION_FIRST = 1
        private const val POSITION_MOVE = 1

        private const val TERMS_OF_RACING_MIN = 0
        private const val TERMS_OF_RACING_MAX = 10

        private const val TERMS_OF_RACING = 4
    }

}