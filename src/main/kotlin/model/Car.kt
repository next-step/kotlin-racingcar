package model

data class Car constructor(private val position: Int) {

    init {
        require(0 <= this.position) { INVALID_POSITION_EXCEPTION }
    }

    fun moveForward(randomValue: Int): Car {
        return spawnAt(position + this.getStep(randomValue))
    }

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

        const val INVALID_POSITION_EXCEPTION = "잘못된 위치에 자동차를 생성하였습니다."

        fun spawnAt(position: Int): Car = Car(position)
    }

    override fun toString(): String = PRINT_STEP_SIGN.repeat(this.position)
}
