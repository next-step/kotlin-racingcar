package racing.model

data class Car(
    val position: Int,
    val name: String = DEFAULT_CAR_NAME
) : Comparable<Car> {

    init {
        require(0 <= position) { INVALID_POSITION_EXCEPTION }
    }

    override fun compareTo(other: Car): Int = position - other.position

    override fun toString(): String = "$name: ${PRINT_STEP_SIGN.repeat(position)}"

    fun moveForward(randomValue: Int): Car = copy(position = position + getStep(randomValue))

    private fun getStep(randomValue: Int): Int = if (canMove(randomValue)) {
        MOVE_STEP_SIZE
    } else {
        STOP
    }

    private fun canMove(randomValue: Int): Boolean = MOVE_BOUNDARY_VALUE <= randomValue

    companion object {

        private const val MOVE_BOUNDARY_VALUE = 4

        private const val MOVE_STEP_SIZE = 1

        private const val STOP = 0

        private const val PRINT_STEP_SIGN = "-"

        private const val DEFAULT_CAR_NAME = "unknown"

        const val INVALID_POSITION_EXCEPTION = "잘못된 위치에 자동차를 생성하였습니다."
    }
}
